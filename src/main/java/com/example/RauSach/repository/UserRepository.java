package com.example.RauSach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RauSach.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{
    User findByUsername(String username);
}
