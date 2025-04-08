package com.example.api.controller;

import com.example.api.dto.StudyCommentDTO;
import com.example.api.service.StudyCommentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/study_comments")
public class StudyCommentController {

    private final StudyCommentService service;

    public StudyCommentController(StudyCommentService service) {
        this.service = service;
    }

    @GetMapping
    public List<StudyCommentDTO> getAll() {
        return service.getAllStudyCommentDTOs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyCommentDTO> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getStudyCommentDTOById(id));
    }

    @PostMapping
    public ResponseEntity<StudyCommentDTO> create(@RequestBody StudyCommentDTO dto) {
        return ResponseEntity.ok(service.createStudyComment(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyCommentDTO> update(@PathVariable Long id, @RequestBody StudyCommentDTO dto) {
        return ResponseEntity.ok(service.updateStudyComment(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStudyComment(id);
        return ResponseEntity.noContent().build();
    }
}