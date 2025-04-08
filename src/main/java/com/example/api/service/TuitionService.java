package com.example.api.service;

import com.example.api.dto.TuitionDTO;
import com.example.api.model.Tuition;
import com.example.api.repository.TuitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TuitionService {

    private final TuitionRepository tuitionRepository;

    public TuitionService(TuitionRepository tuitionRepository) {
        this.tuitionRepository = tuitionRepository;
    }

    // Lấy tất cả bản ghi học phí
    public List<Tuition> getAllTuitions() {
        return tuitionRepository.findAll();
    }

    // Lấy học phí theo ID
    public Tuition getTuitionById(Long id) {
        return tuitionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tuition not found with id: " + id));
    }

    // Tạo mới học phí
    public Tuition createTuition(TuitionDTO dto) {
        Tuition tuition = new Tuition();
        tuition.setStudentId(dto.getStudentId());
        tuition.setDescription(dto.getDescription());
        tuition.setAmount(dto.getAmount());
        tuition.setTuitionDate(dto.getTuitionDate());
        return tuitionRepository.save(tuition);
    }

    // Cập nhật học phí
    public Tuition updateTuition(Long id, TuitionDTO dto) {
        Tuition existing = getTuitionById(id);
        existing.setStudentId(dto.getStudentId());
        existing.setDescription(dto.getDescription());
        existing.setAmount(dto.getAmount());
        existing.setTuitionDate(dto.getTuitionDate());
        return tuitionRepository.save(existing);
    }

    // Xoá học phí
    public void deleteTuition(Long id) {
        tuitionRepository.deleteById(id);
    }
}
