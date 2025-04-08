package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "health")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Health {

    @Id
    private Long id;
    private String name;
    private String birthDate;
    private String gender;
    private double height;
    private double weight;
    private String healthNotes;

    // Getters and Setters
}
