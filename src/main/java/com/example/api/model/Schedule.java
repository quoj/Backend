package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
@Data
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "subject_id")
    private String subjectId;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "day_of_week")
    private String dayOfWeek;  // Đổi từ Integer sang String (hoặc LocalDate)

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;
}
