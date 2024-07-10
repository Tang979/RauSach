package com.example.RauSach.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.RauSach.model.Category;
import com.example.RauSach.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String>{
    Page<Product> findAll(Pageable pageable);
    List<Product> findByNameContainingIgnoreCase(@Param("keyword") String keyword);
    Page<Product> findByCategoryId(String categoryId, Pageable pageable);
}
