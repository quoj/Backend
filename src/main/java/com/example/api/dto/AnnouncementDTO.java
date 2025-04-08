package com.example.api.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnnouncementDTO {
    private String title;
    private String author;
    private String content;
    private String imagePath;
    private LocalDateTime time;
}
