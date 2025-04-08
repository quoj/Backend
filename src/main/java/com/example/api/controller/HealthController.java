package com.example.api.controller;

import com.example.api.dto.HealthDTO;
import com.example.api.model.Health;
import com.example.api.service.HealthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/health")
public class HealthController {

    private final HealthService healthService;

    public HealthController(HealthService healthService) {
        this.healthService = healthService;
    }

    // Lấy danh sách tất cả thông tin sức khỏe
    @GetMapping
    public List<Health> getAll() {
        return healthService.getAllHealthRecords();
    }

    // Lấy thông tin sức khỏe theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Health> getById(@PathVariable Long id) {
        return ResponseEntity.ok(healthService.getHealthRecordById(id));
    }

    // Tạo thông tin sức khỏe mới
    @PostMapping
    public ResponseEntity<Health> create(@RequestBody HealthDTO dto) {
        return ResponseEntity.ok(healthService.createHealthRecord(dto));
    }

    // Cập nhật thông tin sức khỏe theo ID
    @PutMapping("/{id}")
    public ResponseEntity<Health> update(@PathVariable Long id, @RequestBody HealthDTO dto) {
        return ResponseEntity.ok(healthService.updateHealthRecord(id, dto));
    }

    // Xóa thông tin sức khỏe theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        healthService.deleteHealthRecord(id);
        return ResponseEntity.noContent().build();
    }
}
