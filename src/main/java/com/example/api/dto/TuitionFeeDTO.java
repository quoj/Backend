package com.example.api.dto;

import java.time.LocalDate;

public class TuitionFeeDTO {
    private Long id;

    private Double amount;
    private String feeType;
    private LocalDate dueDate;

    public TuitionFeeDTO() {}

    public TuitionFeeDTO(Long id, Double amount, String feeType, LocalDate dueDate) {
        this.id = id;
        this.amount = amount;
        this.feeType = feeType;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getFeeType() {
        return feeType;
    }

    public void setFeeType(String feeType) {
        this.feeType = feeType;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}