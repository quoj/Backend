package com.example.api.dto;

import java.time.LocalDate;
import java.util.List;

public class ClassDTO {

    private Long id;
    private String name;
    private int grade;
    private List<ScheduleDTO> schedules;
    // Chỉ giữ schedules

    public ClassDTO() {
    }

    public ClassDTO(Long id, String name, int grade, List<ScheduleDTO> schedules) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.schedules = schedules;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public List<ScheduleDTO> getSchedules() {
        return schedules;
    }

    public void setSchedules(List<ScheduleDTO> schedules) {
        this.schedules = schedules;
    }
}

