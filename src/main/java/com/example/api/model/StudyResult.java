package com.example.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "study_results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudyResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer studentId; // <-- Chuyển sang ID trực tiếp, không dùng @ManyToOne nữa

    private String category;

    @Column(columnDefinition = "TEXT")
    private String detail;

    private LocalDate resultDate;
}

