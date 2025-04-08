package com.example.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FeedbackDTO {
    private Long id;
    private Long senderId;   // Đổi userId -> senderId
    private Long receiverId; // Thêm receiverId
    private String content;  // Đổi message -> content
    private String status;   // Thêm status nếu cần
    private String imageUrl;
    private LocalDateTime createdAt;
}
