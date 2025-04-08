package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "schedules")
@Data
public class Schedule   {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "class_id")
    private Long classId;

    @Column(name = "subject_id")
    private String  subjectId;

    @Column(name = "teacher_id")
    private Long teacherId;

    @Column(name = "day_of_week")
    private Integer dayOfWeek;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

}
