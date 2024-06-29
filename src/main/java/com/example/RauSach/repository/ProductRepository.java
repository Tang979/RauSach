package com.example.RauSach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RauSach.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,String>{

}
