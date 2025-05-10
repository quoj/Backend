package com.example.api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MenuDTO {
    private Long id;
    private LocalDate date;
    private String breakfast;
    private String lunch;
    private String dinner;
    private LocalDateTime createdAt;  // Thêm trường createdAt
}
