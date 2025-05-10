package com.example.api.dto;

import com.example.api.model.Student.Gender;
import com.example.api.model.Student.AttendanceStatus;
import lombok.Data;

@Data
public class StudentDTO {
    private String name;
    private String dob;
    private Gender gender;
    private String address;
    private String phone;
    private String email;
    private Integer classId;
    private AttendanceStatus attendanceStatus;
}
