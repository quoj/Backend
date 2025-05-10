package com.example.api.controller;

import com.example.api.dto.ClassDiaryDTO;
import com.example.api.model.ClassDiary;
import com.example.api.service.ClassDiaryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/class_diaries")
public class ClassDiaryController {

    private final ClassDiaryService service;

    public ClassDiaryController(ClassDiaryService service) {
        this.service = service;
    }

    @GetMapping
    public List<ClassDiary> getAll() {
        return service.getAllClassDiaries();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassDiary> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getClassDiaryById(id).orElseThrow());
    }

    @PostMapping
    public ResponseEntity<ClassDiary> create(@RequestBody ClassDiaryDTO dto) {
        return ResponseEntity.ok(service.createClassDiary(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassDiary> update(@PathVariable Long id, @RequestBody ClassDiaryDTO dto) {
        return ResponseEntity.ok(service.updateClassDiary(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteClassDiary(id);
        return ResponseEntity.noContent().build();
    }
}
