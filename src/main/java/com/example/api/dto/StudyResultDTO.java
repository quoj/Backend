package com.example.api.dto;

import java.time.LocalDate;

public class StudyResultDTO {

    private Long id;
    private Integer studentId;
    private String category; // Đánh giá, Chuyên cần, Phiếu bé ngoan, ...
    private String detail;   // Nội dung chi tiết kết quả
    private LocalDate resultDate; // Ngày cập nhật kết quả

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public LocalDate getResultDate() {
        return resultDate;
    }

    public void setResultDate(LocalDate resultDate) {
        this.resultDate = resultDate;
    }
}
