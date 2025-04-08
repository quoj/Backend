package com.example.api.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "study_comments")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudyComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", nullable = false) // 💥 Bắt buộc ánh xạ đúng tên cột
    private Student student;

    @Column(name = "comment_type")
    private String commentType;

    @Column(name = "comment_text")
    private String commentText;

    @Column(name = "comment_date")
    private LocalDate commentDate;
}
