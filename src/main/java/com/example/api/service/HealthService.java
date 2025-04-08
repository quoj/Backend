package com.example.api.service;

import com.example.api.dto.HealthDTO;
import com.example.api.model.Health;
import com.example.api.repository.HealthRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthService {

    private final HealthRepository healthRepository;

    public HealthService(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    // Lấy tất cả bản ghi sức khỏe
    public List<Health> getAllHealthRecords() {
        return healthRepository.findAll();
    }

    // Lấy bản ghi sức khỏe theo ID
    public Health getHealthRecordById(Long id) {
        return healthRepository.findById(id).orElseThrow(() -> new RuntimeException("Health record not found"));
    }

    // Tạo bản ghi sức khỏe mới
    public Health createHealthRecord(HealthDTO dto) {
        Health health = new Health();
        health.setName(dto.getName());
        health.setBirthDate(dto.getBirthDate());
        health.setGender(dto.getGender());
        health.setHeight(dto.getHeight());
        health.setWeight(dto.getWeight());
        health.setHealthNotes(dto.getHealthNotes());
        return healthRepository.save(health);
    }

    // Cập nhật bản ghi sức khỏe
    public Health updateHealthRecord(Long id, HealthDTO dto) {
        Health health = healthRepository.findById(id).orElseThrow(() -> new RuntimeException("Health record not found"));
        health.setName(dto.getName());
        health.setBirthDate(dto.getBirthDate());
        health.setGender(dto.getGender());
        health.setHeight(dto.getHeight());
        health.setWeight(dto.getWeight());
        health.setHealthNotes(dto.getHealthNotes());
        return healthRepository.save(health);
    }

    // Xóa bản ghi sức khỏe
    public void deleteHealthRecord(Long id) {
        Health health = healthRepository.findById(id).orElseThrow(() -> new RuntimeException("Health record not found"));
        healthRepository.delete(health);
    }
}
