package com.example.api.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ScheduleDTO {
    private Long id;
    private Long classId;
    private String subjectId;
    private Long teacherId;
    private String dayOfWeek;  // Đổi từ Integer sang String (hoặc LocalDate)
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
