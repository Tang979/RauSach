package com.example.RauSach.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RauSach.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String>{
    Optional<User> findByUsername(String username);
}
