package com.example.api.dto;


import lombok.Data;

import java.util.Date;
import java.util.List;

@Data

public class StudentDTO {

    private Long id;
    private String name;
    private String gender;
    private String address;
    private String email;
    private Date dob;
    private String dad;
    private String mom;
    private String phoneDad;
    private String phoneMom;
    private Long classId;  // Chỉ cần ID của lớp học
    private List<AttendanceDTO> attendents;  // Thêm danh sách AttendanceDTO


    // Constructor không tham số
    public StudentDTO() {
    }

    // Constructor với tham số
    public StudentDTO(Long id, String name, String gender, String address, String email, Date dob, String dad, String mom, String phoneDad, String phoneMom, Long classId, List<AttendanceDTO> attendents) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.dob = dob;
        this.dad = dad;
        this.mom = mom;
        this.phoneDad = phoneDad;
        this.phoneMom = phoneMom;
        this.classId = classId;
        this.attendents = attendents;
    }

    // Getters và Setters
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getDad() {
        return dad;
    }

    public void setDad(String dad) {
        this.dad = dad;
    }

    public String getMom() {
        return mom;
    }

    public void setMom(String mom) {
        this.mom = mom;
    }

    public String getPhoneDad() {
        return phoneDad;
    }

    public void setPhoneDad(String phoneDad) {
        this.phoneDad = phoneDad;
    }

    public String getPhoneMom() {
        return phoneMom;
    }

    public void setPhoneMom(String phoneMom) {
        this.phoneMom = phoneMom;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }

    public List<AttendanceDTO> getAttendents() {
        return attendents;
    }

    public void setAttendents(List<AttendanceDTO> attendents) {
        this.attendents = attendents;
    }
}
