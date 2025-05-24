package com.example.api.model;

import jakarta.persistence.*;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "attendance")
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)// Liên kết đến bảng Student
    @JsonBackReference(value = "student-attendance")
    private Student student;  // Liên kết với Student

    @Enumerated(EnumType.STRING)  // Chỉ định sử dụng enum và lưu dưới dạng String
    @Column(nullable = false)
    private AttendanceEnum status;  // Trạng thái điểm danh (Có mặt, Vắng mặt, Nghỉ không phép)

    @Column(name = "date", nullable = false)
    private LocalDate date; // Ngày điểm danh

    @Column(name = "time", nullable = false)
    private LocalTime time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
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

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
