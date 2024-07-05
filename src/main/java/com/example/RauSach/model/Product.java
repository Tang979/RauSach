package com.example.RauSach.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @NotBlank(message = "Tên không được để trống")
    private String name;
    @NotNull(message = "Không được để trống")
    @Min(1000)
    private double price;
    @NotBlank(message = "Không được để trống")
    private String imageURL;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
