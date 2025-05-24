package com.example.api.dto;

import com.example.api.model.AttendanceEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;



public class AttendanceDTO {
    private Long id;
    private StudentDTO student; // thay vì Long studentId
    private AttendanceEnum status;
    private LocalDate date;
    private Time time;

    public AttendanceDTO() {}

    public AttendanceDTO(Long id, StudentDTO student, AttendanceEnum status, LocalDate date, Time time) {
        this.id = id;
        this.student = student;
        this.status = status;
        this.date = date;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public AttendanceEnum getStatus() {
        return status;
    }

    public void setStatus(AttendanceEnum status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
