package com.example.RauSach.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@Entity
@Table(name = "oder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private LocalDate orderDate = LocalDate.now();
    private String customerEmail;
    private String customerName;
    private String customerPhone;
    private String customerAddress;
    private String oderStatus;
    private Double total;


    public Double getTotal() {
        return total;
    }
    public void setCustomerEmail(String customerEmail){
        this.customerEmail = customerEmail;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }
    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }
    public void setOderStatus(String oderStatus){
        this.oderStatus = oderStatus;
    }
    public void setTotal(Double total) {
        this.total = total;
    }
}