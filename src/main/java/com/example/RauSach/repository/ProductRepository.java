package com.example.RauSach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.RauSach.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String>{
    List<Product> findByNameContainingIgnoreCase(@Param("keyword") String keyword);
}
