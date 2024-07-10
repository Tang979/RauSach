package com.example.RauSach.controller;

import com.example.RauSach.service.MoMoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
public class MoMoPaymentController {

    @Autowired
    private MoMoPaymentService moMoPaymentService;

    @GetMapping("/MoMoPayment")
    public String getMoMoPaymentPage() {
        return "momo/momo_payment"; // Đây là view cho trang thanh toán MoMo
    }

    @PostMapping("/MoMoPayment")
    public String handleMoMoPayment(RedirectAttributes redirectAttributes) {
        try {
            String response = moMoPaymentService.createPayment();
            // Xử lý phản hồi và chuyển hướng tới trang thanh toán MoMo
            redirectAttributes.addFlashAttribute("paymentResponse", response);
            return "redirect:/MoMoPaymentSuccess"; // Điều hướng tới trang thành công
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/MoMoPaymentError"; // Điều hướng tới trang lỗi
        }
    }

    @GetMapping("/MoMoPaymentSuccess")
    public String getMoMoPaymentSuccessPage() {
        return "momo_payment_success"; // View cho trang thành công
    }

    @GetMapping("/MoMoPaymentError")
    public String getMoMoPaymentErrorPage() {
        return "momo_payment_error"; // View cho trang lỗi
    }
}