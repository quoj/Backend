package com.example.api.service;

import com.example.api.dto.ClassDiaryDTO;
import com.example.api.model.ClassDiary;
import com.example.api.repository.ClassDiaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassDiaryService {

    private final ClassDiaryRepository repository;

    @Autowired
    public ClassDiaryService(ClassDiaryRepository repository) {
        this.repository = repository;
    }

    public List<ClassDiary> getAllClassDiaries() {
        return repository.findAll();
    }

    public Optional<ClassDiary> getClassDiaryById(Long id) {
        return repository.findById(id);
    }

    public ClassDiary createClassDiary(ClassDiaryDTO dto) {
        ClassDiary classDiary = new ClassDiary();
        classDiary.setClassId(dto.getClassId());
        classDiary.setDate(dto.getDate());
        classDiary.setActivities(dto.getActivities());
        classDiary.setMood(dto.getMood());
        classDiary.setHealthStatus(dto.getHealthStatus());
        classDiary.setTeacherNote(dto.getTeacherNote());
        classDiary.setImagePath(dto.getImagePath());
        return repository.save(classDiary);
    }

    public ClassDiary updateClassDiary(Long id, ClassDiaryDTO dto) {
        ClassDiary classDiary = repository.findById(id).orElseThrow();
        classDiary.setClassId(dto.getClassId());
        classDiary.setDate(dto.getDate());
        classDiary.setActivities(dto.getActivities());
        classDiary.setMood(dto.getMood());
        classDiary.setHealthStatus(dto.getHealthStatus());
        classDiary.setTeacherNote(dto.getTeacherNote());
        classDiary.setImagePath(dto.getImagePath());
        return repository.save(classDiary);
    }

    public void deleteClassDiary(Long id) {
        repository.deleteById(id);
    }
}
