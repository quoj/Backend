package com.example.api.dto;

import lombok.Data;

@Data
public class TeacherDTO {
    private Long id;
    private String name;
    private String phone;
    private String email;
    private Integer subjectId;
    private String department;
}
