// src/main/java/com/example/api/model/Attendance.java
package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "attendance")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    @Column(name = "class_id")          // nếu bạn đã thêm cột này rồi
    private Integer classId;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "date", nullable = false)
    private LocalDateTime date;

    @Column(name = "note")
    private String note;

    @PrePersist
    protected void onCreate() {
        this.date = LocalDateTime.now();
    }
}
