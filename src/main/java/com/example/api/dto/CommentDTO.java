package com.example.api.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class CommentDTO {
    private int id;
    private long announcementId;
    private int studentId;
    private String content;
    private LocalDateTime createdAt;
}
