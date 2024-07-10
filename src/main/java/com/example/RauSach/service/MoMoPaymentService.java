package com.example.RauSach.service;

import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class MoMoPaymentService {

    private static final String ENDPOINT = "https://test-payment.momo.vn/v2/gateway/api/create";
    private static final String ACCESS_KEY = "klm05TvNBzhg7h7j";
    private static final String SECRET_KEY = "at67qH6mk8w5Y1nAyMoYKMWACiEi2bsa";
    private static final String PARTNER_CODE = "MOMOBKUN20180529";

    public String createPayment() throws IOException {
        OkHttpClient client = new OkHttpClient();

        // Tạo thông tin thanh toán
        Map<String, Object> paymentInfo = new HashMap<>();
        paymentInfo.put("partnerCode", PARTNER_CODE);
        paymentInfo.put("accessKey", ACCESS_KEY);
        paymentInfo.put("requestId", "unique_request_id");
        paymentInfo.put("amount", "10000");
        paymentInfo.put("orderId", "unique_order_id");
        paymentInfo.put("orderInfo", "Thanh toán đơn hàng");
        paymentInfo.put("returnUrl", "https://your-return-url");
        paymentInfo.put("notifyUrl", "https://your-notify-url");

        // Chuyển đổi thông tin thanh toán thành JSON
        Gson gson = new Gson();
        String json = gson.toJson(paymentInfo);

        // Tạo request body
        RequestBody body = RequestBody.create(json, MediaType.get("application/json; charset=utf-8"));

        // Tạo request
        Request request = new Request.Builder()
                .url(ENDPOINT)
                .post(body)
                .build();

        // Gửi request và nhận phản hồi
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Unexpected code " + response);
            }

            // Xử lý phản hồi
            return response.body().string();
        }
    }
}
