package com.example.api.dto;

public class NotificationDTO {
    private String title;
    private String content;
    private Integer classId;

    // 🔽 Thêm getter và setter
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }

    public Integer getClassId() { return classId; }
    public void setClassId(Integer classId) { this.classId = classId; }
}
