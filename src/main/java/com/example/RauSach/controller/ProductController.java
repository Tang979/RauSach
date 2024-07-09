package com.example.RauSach.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.RauSach.model.Product;
import com.example.RauSach.service.CategoryService;
import com.example.RauSach.service.ProductService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;
    
    // @GetMapping()
    // public String showProduct(Model model) {
    //     model.addAttribute("products", productService.getAllProduct());
    //     return "/product/product-list";
    // }

    @GetMapping("/add")
    public String showAddProducString(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryService.getAllCategories());
        return "/product/product-add";
    }

    @PostMapping("/add")
    public String saveProduct(@Valid Product newProduct,
            BindingResult result,
            @RequestParam MultipartFile imageProduct,
            Model model) {
        if (result.hasErrors()) {
            model.addAttribute("product", newProduct);
            return "product/add";
        }
        productService.updateImage(newProduct, imageProduct);
        productService.addProduct(newProduct);
        return "redirect:/admin/products/list";
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @GetMapping()
    public String index(Model model,
                        @RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "5") int size) {
        Page<Product> products = productService.GetAll(page, size);
        model.addAttribute("products", products.getContent());
        model.addAttribute("listproduct", products);
        model.addAttribute("totalPages", products.getTotalPages());
        return "/product/product-list";
    }
}

