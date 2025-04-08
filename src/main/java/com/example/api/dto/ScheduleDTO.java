package com.example.api.dto;

import lombok.Data;

@Data
public class ScheduleDTO {
    private Long id;
    private Long classId;
    private String subjectId;
    private Long teacherId;
    private Integer dayOfWeek;
    private String startTime;
    private String endTime;
}
