package com.example.RauSach.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.RauSach.model.CartItem;
import com.example.RauSach.service.CartService;

@RestController // Sử dụng @RestController thay vì @Controller để trả về JSON thay vì HTML
@RequestMapping("/api/cart")
public class CartApiController {

    @Autowired
    private CartService cartService;

    @GetMapping("/items")
    public ResponseEntity<List<CartItem>> getCartItems() {
        List<CartItem> cartItems = cartService.getCartItems();
        return ResponseEntity.ok(cartItems);
    }
}