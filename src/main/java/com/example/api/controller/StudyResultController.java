package com.example.api.controller;

import com.example.api.dto.StudyResultDTO;
import com.example.api.service.StudyResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/study_results")
public class StudyResultController {

    private final StudyResultService service;

    public StudyResultController(StudyResultService service) {
        this.service = service;
    }

    // Trả về danh sách StudyResultDTO
    @GetMapping
    public ResponseEntity<List<StudyResultDTO>> getAll() {
        return ResponseEntity.ok(service.getAllStudyResults());
    }

    // Trả về StudyResultDTO theo id
    @GetMapping("/{id}")
    public ResponseEntity<StudyResultDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudyResultById(id));
    }

    // Tạo mới StudyResult từ DTO
    @PostMapping
    public ResponseEntity<StudyResultDTO> create(@RequestBody StudyResultDTO dto) {
        return ResponseEntity.ok(service.createStudyResult(dto));
    }

    // Cập nhật StudyResult từ DTO
    @PutMapping("/{id}")
    public ResponseEntity<StudyResultDTO> update(@PathVariable Long id, @RequestBody StudyResultDTO dto) {
        return ResponseEntity.ok(service.updateStudyResult(id, dto));
    }

    // Xóa kết quả
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStudyResult(id);
        return ResponseEntity.noContent().build();
    }
}
