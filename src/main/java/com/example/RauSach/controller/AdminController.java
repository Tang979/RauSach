package com.example.RauSach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.RauSach.service.CategoryService;
import com.example.RauSach.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
     @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/dash-board")
    public String showDashBoard() {
        return "/admin/dash-board";
    }
    @GetMapping("/products/list")
    public String showProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "/admin/product-manager";
    }
}
