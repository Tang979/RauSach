package com.example.RauSach.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
public class MomoResponse {
    private String partnerCode;
    private String requestId;
    private String orderId;
    private long amount;
    private String responseTime;
    private String message;
    private int resultCode;
    private String payUrl;
    


}
