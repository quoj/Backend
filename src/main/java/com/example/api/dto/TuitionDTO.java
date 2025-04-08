package com.example.api.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TuitionDTO {

    private Long studentId;
    private String description;
    private BigDecimal amount;
    private LocalDate tuitionDate;

    // Constructor mặc định được Lombok sinh ra nhờ @Data
    // Lombok tự động tạo getters, setters, toString, equals, hashCode

    public TuitionDTO(Long studentId, String description, BigDecimal amount, LocalDate tuitionDate) {
        this.studentId = studentId;
        this.description = description;
        this.amount = amount;
        this.tuitionDate = tuitionDate;
    }
}
