package com.example.api.repository;

import com.example.api.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    // Có thể thêm custom query nếu cần
}
