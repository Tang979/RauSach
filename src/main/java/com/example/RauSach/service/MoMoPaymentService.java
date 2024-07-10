package com.example.RauSach.service;

import com.example.RauSach.model.PaymentResponse;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MoMoPaymentService {

    private static final String PARTNER_CODE = "MOMOBKUN20180529";
    private static final String ACCESS_KEY = "klm05TvNBzhg7h7j";
    private static final String SECRET_KEY = "at67qH6mk8w5Y1nAyMoYKMWACiEi2bsa";
    private static final String ENDPOINT = "https://test-payment.momo.vn/gw_payment/transactionProcessor";
    private static final String RETURN_URL = "http://localhost:8080/MoMoPaymentSuccess";
    private static final String NOTIFY_URL = "http://localhost:8080/MoMoPaymentNotify";

    public PaymentResponse createPayment() throws IOException {
        Map<String, String> payload = new HashMap<>();
        payload.put("partnerCode", PARTNER_CODE);
        payload.put("accessKey", ACCESS_KEY);
        payload.put("requestId", String.valueOf(System.currentTimeMillis()));
        payload.put("amount", "1000");
        payload.put("orderId", String.valueOf(System.currentTimeMillis()));
        payload.put("orderInfo", "Thanh toán thử nghiệm");
        payload.put("returnUrl", RETURN_URL);
        payload.put("notifyUrl", NOTIFY_URL);
        payload.put("requestType", "captureMoMoWallet");

        // Sign the payload with your secret key
        String signature = signPayload(payload, SECRET_KEY);
        payload.put("signature", signature);

        // Send request to MoMo API and get the payment URL
        String jsonResponse = sendPostRequest(ENDPOINT, payload);
        Map<String, Object> responseMap = new ObjectMapper().readValue(jsonResponse, HashMap.class);

        PaymentResponse paymentResponse = new PaymentResponse();
        paymentResponse.setQrCodeUrl((String) responseMap.get("payUrl"));
        paymentResponse.setErrorCode(String.valueOf(responseMap.get("errorCode")));
        paymentResponse.setErrorMessage((String) responseMap.get("errorMessage"));

        return paymentResponse;
    }

    private String signPayload(Map<String, String> payload, String secretKey) {
        // Logic to sign the payload with the secret key
        // For example, using HMAC SHA256
        return "signature";
    }

    private String sendPostRequest(String url, Map<String, String> payload) throws IOException {
        try (CloseableHttpClient client = HttpClients.createDefault()) {
            HttpPost post = new HttpPost(url);
            post.setEntity(new StringEntity(new ObjectMapper().writeValueAsString(payload)));
            post.setHeader("Content-type", "application/json");

            return EntityUtils.toString(client.execute(post).getEntity());
        }
    }
}
