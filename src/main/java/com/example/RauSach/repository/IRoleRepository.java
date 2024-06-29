package com.example.RauSach.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.RauSach.model.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, String> {
    Role findRoleById(String id);
}