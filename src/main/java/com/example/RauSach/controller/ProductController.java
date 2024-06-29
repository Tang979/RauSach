package com.example.RauSach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.RauSach.service.ProductService;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping()
    public String showProduct(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "/product/product-list";
    }
    

}
