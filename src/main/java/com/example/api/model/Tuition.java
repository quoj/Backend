package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "tuitions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tuition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // student_id: int(11), không null
    @Column(name = "student_id", nullable = false)
    private Long studentId;

    // description: varchar(255), không null
    @Column(nullable = false, length = 255)
    private String description;

    // amount: decimal(38,2), có thể null
    @Column(precision = 38, scale = 2)
    private BigDecimal amount;

    // tuition_date: date, có thể null
    @Column(name = "tuition_date")
    private LocalDate tuitionDate;
}
