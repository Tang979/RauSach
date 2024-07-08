package com.example.RauSach.model;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "oder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDate oderDate;
    private Long totalAmount;
    public void setCustomerName(String customerName) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setCustomerName'");
    }
}
