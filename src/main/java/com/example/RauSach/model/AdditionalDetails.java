package com.example.RauSach.model;

public class AdditionalDetails {
    private String transactionId;
        private String paymentDate;

        public AdditionalDetails(String transactionId, String paymentDate) {
            this.transactionId = transactionId;
            this.paymentDate = paymentDate;
        }

        public String getTransactionId() {
            return transactionId;
        }

        public void setTransactionId(String transactionId) {
            this.transactionId = transactionId;
        }

        public String getPaymentDate() {
            return paymentDate;
        }

        public void setPaymentDate(String paymentDate) {
            this.paymentDate = paymentDate;
        }
    }
