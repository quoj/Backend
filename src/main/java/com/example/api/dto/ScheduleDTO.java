package com.example.api.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ScheduleDTO {
    private Long id;
    private Long classId;
    private String subjectId;
    private Long teacherId;
    //    private String dayOfWeek;
    private String startTime;
    private String endTime;

    // Constructors
    public ScheduleDTO() {
    }
//    public ScheduleDTO(Long id, Long classId, String subjectId, Long teacherId, String dayOfWeek, String startTime, String endTime) {
//        this.id = id;
//        this.classId = classId;
//        this.subjectId = subjectId;
//        this.teacherId = teacherId;
//        this.dayOfWeek = dayOfWeek;
//        this.startTime = startTime;
//        this.endTime = endTime;
//    }


    public ScheduleDTO(Long id, Long classId, String subjectId, Long teacherId, String startTime, String endTime) {
        this.id = id;
        this.classId = classId;
        this.subjectId = subjectId;
        this.teacherId = teacherId;
        this.startTime = startTime;
        this.endTime = endTime;
    }


    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
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