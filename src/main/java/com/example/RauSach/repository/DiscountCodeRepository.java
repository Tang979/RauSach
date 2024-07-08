package com.example.RauSach.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RauSach.model.DiscountCode;
import com.google.common.base.Optional;

public interface DiscountCodeRepository extends JpaRepository<DiscountCode, Long> {
    Optional<DiscountCode> findByCode(String code);
}

