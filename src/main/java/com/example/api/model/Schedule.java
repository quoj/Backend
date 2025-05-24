package com.example.api.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    @JsonBackReference(value = "classes-schedules")
    private SchoolClass clazz;

    @Column(name = "subject_id")
    private String subjectId;

    @Column(name = "teacher_id")
    private Long teacherId;

//    @Column(name = "day_of_week")
//    private String dayOfWeek;

    @Column(name = "start_time")
    private String startTime;

    @Column(name = "end_time")
    private String endTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SchoolClass getClazz() {
        return clazz;
    }

    public void setClazz(SchoolClass clazz) {
        this.clazz = clazz;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

//    public String getDayOfWeek() {
//        return dayOfWeek;
//    }
//
//    public void setDayOfWeek(String dayOfWeek) {
//        this.dayOfWeek = dayOfWeek;
//    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
