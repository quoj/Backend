package com.example.api.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class MessageDTO {
    private Long id;
    private Long senderId;
    private Long receiverId;
    private Long studentId;
    private String content;
    private String imagePath;
    private String status;
    private LocalDateTime createdAt;
}
