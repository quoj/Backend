package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String dob;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;

    private String phone;

    private String email;

    @Column(name = "class_id")
    private Integer classId;

    @Enumerated(EnumType.STRING)
    @Column(name = "attendance_status")
    private AttendanceStatus attendanceStatus;

    public enum Gender {
        Nam,
        Nu,
        Khac
    }

    public enum AttendanceStatus {
        present,
        absent
    }
}
