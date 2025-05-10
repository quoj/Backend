package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "parents")
public class Parent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String phone;

    private String email;

    @Enumerated(EnumType.STRING)
    private Relationship relationship;

    @Column(name = "student_id")
    private Integer studentId;

    // Getters & Setters
    // (generate them via IDE or Lombok)

    // Enum cho relationship
    public enum Relationship {
        Bố, Mẹ, Người_giám_hộ
    }
}
