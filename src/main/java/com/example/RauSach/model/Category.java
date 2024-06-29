package com.example.RauSach.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank(message = "Tên là bắt buộc")
    private String name;
}
