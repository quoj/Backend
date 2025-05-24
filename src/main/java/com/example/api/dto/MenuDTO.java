package com.example.api.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MenuDTO {
    private Long id;
    private String dayOfWeek;
    private LocalDate date;
    private String breakfast;
    private String second_breakfast;
    private String lunch;
    private String dinner;
    private String second_dinner;
    private LocalDateTime createdAt;  // Thêm trường createdAt

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getSecond_breakfast() {
        return second_breakfast;
    }

    public void setSecond_breakfast(String second_breakfast) {
        this.second_breakfast = second_breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSecond_dinner() {
        return second_dinner;
    }

    public void setSecond_dinner(String second_dinner) {
        this.second_dinner = second_dinner;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }
}