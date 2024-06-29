package com.example.RauSach.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.RauSach.model.Product;
import com.example.RauSach.repository.ProductRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    public List<Product> getAllProduct(){
        return productRepository.findAll();
    }
    // Retrieve a product by its id
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    // Add a new product to the database
    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    // Update an existing product
    public Product updateProduct(@NotNull Product product) {
        Product existingProduct = productRepository.findById(product.getId())
                .orElseThrow(() -> new IllegalStateException("Product with ID " +
                        product.getId() + " does not exist."));
        existingProduct.setName(product.getName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setCategory(product.getCategory());
        return productRepository.save(existingProduct);
    }

    // Delete a product by its id
    public void deleteProductById(String id) {
        if (!productRepository.existsById(id)) {
            throw new IllegalStateException("Product with ID " + id + " does not exist.");
        }
        productRepository.deleteById(id);
    }
}
