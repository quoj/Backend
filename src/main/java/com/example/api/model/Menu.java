package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "menus")
@Data
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @Column(columnDefinition = "TEXT")
    private String breakfast;

    @Column(columnDefinition = "TEXT")
    private String lunch;

    @Column(columnDefinition = "TEXT")
    private String dinner;

    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;  // Thêm trường createdAt

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();  // Đảm bảo createdAt được điền khi tạo mới
    }
}
