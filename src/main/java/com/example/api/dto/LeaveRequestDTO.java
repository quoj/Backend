package com.example.api.dto;

import java.time.LocalDate;

public class LeaveRequestDTO {
    private Long studentId;
    private String reason;
    private LocalDate date;
    private String status;

    // Getters và Setters
    public Long getStudentId() { return studentId; }
    public void setStudentId(Long studentId) { this.studentId = studentId; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
