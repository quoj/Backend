package com.example.api.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "student_id", nullable = false)
    private Long studentId;

    private String reason;
    private LocalDate date;
    private String status;

    @Column(name = "request_time", nullable = false, updatable = false)
    private LocalDate requestTime;

    public LeaveRequest() {}

    // Constructor set luôn requestTime
    public LeaveRequest(Long studentId, String reason, LocalDate date, String status) {
        this.studentId = studentId;
        this.reason = reason;
        this.date = date;
        this.status = status;
        this.requestTime = LocalDate.now(); // Tự set ở đây
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public LocalDate getRequestTime() { return requestTime; }
    public void setRequestTime(LocalDate requestTime) { this.requestTime = requestTime; }
}
