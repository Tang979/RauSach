package com.example.RauSach.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.RauSach.model.Category;
import com.example.RauSach.service.CategoryService;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/categories")
public class CategoryApiController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }
    @PostMapping
    public Category createCategory(@RequestBody Category category) {
        return categoryService.addCategory(category);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable String id) {
        Category product = categoryService.getCategoryById(id)
                .orElseThrow(() -> new RuntimeException("Product not found on :: "
                        + id));
        return ResponseEntity.ok().body(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> updateProduct(@PathVariable String id,
            @RequestBody Category productDetails) {
        Category product = categoryService.getCategoryById(id)
                .orElseThrow(() -> new RuntimeException("Product not found on :: " + id));
        product.setName(productDetails.getName());
        final Category updatedProduct = categoryService.addCategory(product);
        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        Category product = categoryService.getCategoryById(id)
                .orElseThrow(() -> new RuntimeException("Product not found on :: " + id));
        categoryService.deleteCategoryById(id);
        return ResponseEntity.ok().build();
    }
}