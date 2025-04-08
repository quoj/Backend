package com.example.api.controller;

import com.example.api.dto.TuitionDTO;
import com.example.api.model.Tuition;
import com.example.api.service.TuitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tuitions")
public class TuitionsController {

    private final TuitionService tuitionService;

    public TuitionsController(TuitionService tuitionService) {
        this.tuitionService = tuitionService;
    }

    // Lấy danh sách tất cả học phí
    @GetMapping
    public List<Tuition> getAll() {
        return tuitionService.getAllTuitions();
    }

    // Lấy học phí theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Tuition> getById(@PathVariable Long id) {
        return ResponseEntity.ok(tuitionService.getTuitionById(id));
    }

    // Tạo học phí mới
    @PostMapping
    public ResponseEntity<Tuition> create(@RequestBody TuitionDTO dto) {
        return ResponseEntity.ok(tuitionService.createTuition(dto));
    }

    // Cập nhật học phí theo ID
    @PutMapping("/{id}")
    public ResponseEntity<Tuition> update(@PathVariable Long id, @RequestBody TuitionDTO dto) {
        return ResponseEntity.ok(tuitionService.updateTuition(id, dto));
    }

    // Xóa học phí theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tuitionService.deleteTuition(id);
        return ResponseEntity.noContent().build();
    }
}
