package com.example.api.repository;

import com.example.api.model.ClassDiary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassDiaryRepository extends JpaRepository<ClassDiary, Long> {
}
