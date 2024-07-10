package com.example.RauSach.controller;

import com.example.RauSach.service.MoMoPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/MoMoPayment")
public class MoMoPaymentController {

    @Autowired
    private MoMoPaymentService moMoPaymentService;

    @GetMapping
    public String handlePayment() {
        try {
            String response = moMoPaymentService.createPayment();
            // Xử lý phản hồi của MoMo nếu cần thiết
            return "redirect:" + response; // Chuyển hướng đến trang thanh toán của MoMo
        } catch (IOException e) {
            e.printStackTrace();
            return "error"; // Trang lỗi nếu có vấn đề trong quá trình thanh toán
        }
    }
}
