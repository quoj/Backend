package com.example.api.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "tuition_fee")
public class TuitionFee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "fee_type", nullable = false)
    private String feeType;

    @Column(name = "due_date", nullable = false)
    private LocalDate dueDate;

    // Constructors
    public TuitionFee() {
    }

    public TuitionFee(Long id, Double amount, String feeType, LocalDate dueDate) {
        this.id = id;
        this.amount = amount;
        this.feeType = feeType;
        this.dueDate = dueDate;
    }

    // Getters & Setters
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
