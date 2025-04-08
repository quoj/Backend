package com.example.api.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Ví dụ, tên học sinh

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)  // Liên kết ngược từ Student đến StudyComment
    private List<StudyComment> studyComments;

    // Getters and Setters
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

    public List<StudyComment> getStudyComments() {
        return studyComments;
    }

    public void setStudyComments(List<StudyComment> studyComments) {
        this.studyComments = studyComments;
    }
}
