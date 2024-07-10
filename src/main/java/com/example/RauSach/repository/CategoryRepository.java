package com.example.RauSach.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RauSach.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String>{
    List<Category> findByNameContainingIgnoreCase(String keyword);
}
