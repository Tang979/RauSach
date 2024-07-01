package com.example.RauSach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RauSach.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category,String>{

}
