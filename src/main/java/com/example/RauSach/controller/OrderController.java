package com.example.RauSach.controller;

import com.example.RauSach.model.CartItem;
import com.example.RauSach.model.Order;
import com.example.RauSach.service.OrderService;
import com.example.RauSach.service.CartService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private CartService cartService;

    @PostMapping("/order/submit")
    public String submitOrder(@RequestParam("customerName") String customerName,
                              @RequestParam("customerEmail") String customerEmail,
                              @RequestParam("customerPhone") String customerPhone,
                              @RequestParam("customerAddress") String customerAddress,
                              @RequestParam("oderStatus") String oderStatus,
                              @RequestParam("total") Double total,
                              Model model) {
            List<CartItem> cartItems = cartService.getCartItems();
        if (cartItems.isEmpty()) {
            return "redirect:/cart"; // Redirect if cart is empty
        }
            Order order = orderService.createOrder(customerName, customerEmail, customerPhone, customerAddress, oderStatus, total, cartItems);
            model.addAttribute("order", order);
            return "/cart/Order-Confirmation"; // Redirect to confirmation page or another appropriate view
        
    }
}
