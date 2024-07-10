package com.example.RauSach.controller;

import com.example.RauSach.model.PaymentResponse;
import com.example.RauSach.service.MoMoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class MoMoPaymentController {

    @Autowired
    private MoMoPaymentService moMoPaymentService;

    @GetMapping("/momo/payment")
    public String initiateMoMoPayment(RedirectAttributes redirectAttributes) {
        try {
            // Gọi service để lấy thông tin thanh toán từ MoMo
            PaymentResponse paymentResponse = moMoPaymentService.createPayment();

            // Kiểm tra và chuyển hướng nếu nhận được URL thanh toán từ MoMo
            if (paymentResponse != null && paymentResponse.getQrCodeUrl() != null) {
                // Chuyển hướng người dùng đến trang thanh toán MoMo
                return "redirect:" + paymentResponse.getQrCodeUrl();
            } else {
                // Xử lý khi không nhận được URL thanh toán từ MoMo
                // Ví dụ: Hiển thị thông báo lỗi
                String errorMessage = paymentResponse != null ? paymentResponse.getErrorMessage() : "Không thể khởi tạo thanh toán với MoMo. Vui lòng thử lại sau.";
                redirectAttributes.addFlashAttribute("error", errorMessage);
                return "redirect:/cart"; // Chuyển hướng về trang giỏ hàng hoặc trang khác
            }
        } catch (IOException e) {
            // Xử lý ngoại lệ khi gọi service
            redirectAttributes.addFlashAttribute("error", "Đã xảy ra lỗi khi kết nối với MoMo. Vui lòng thử lại sau.");
            return "redirect:/cart"; // Chuyển hướng về trang giỏ hàng hoặc trang khác
        }
    }
}
