package com.example.api.service;

import com.example.api.dto.StudyResultDTO;
import com.example.api.model.StudyResult;
import com.example.api.repository.StudyResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudyResultService {

    private final StudyResultRepository repository;

    public StudyResultService(StudyResultRepository repository) {
        this.repository = repository;
    }

    // Trả về danh sách DTO
    public List<StudyResultDTO> getAllStudyResults() {
        return repository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    // Trả về 1 DTO theo ID
    public StudyResultDTO getStudyResultById(Long id) {
        StudyResult result = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudyResult not found"));
        return toDTO(result);
    }

    // Tạo mới
    public StudyResultDTO createStudyResult(StudyResultDTO dto) {
        StudyResult studyResult = new StudyResult();
        studyResult.setStudentId(dto.getStudentId());
        studyResult.setCategory(dto.getCategory());
        studyResult.setDetail(dto.getDetail());
        studyResult.setResultDate(dto.getResultDate());

        return toDTO(repository.save(studyResult));
    }

    // Cập nhật
    public StudyResultDTO updateStudyResult(Long id, StudyResultDTO dto) {
        StudyResult studyResult = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("StudyResult not found"));

        studyResult.setStudentId(dto.getStudentId());
        studyResult.setCategory(dto.getCategory());
        studyResult.setDetail(dto.getDetail());
        studyResult.setResultDate(dto.getResultDate());

        return toDTO(repository.save(studyResult));
    }

    // Xóa
    public void deleteStudyResult(Long id) {
        repository.deleteById(id);
    }

    // Helper method để map entity -> DTO
    private StudyResultDTO toDTO(StudyResult entity) {
        StudyResultDTO dto = new StudyResultDTO();
        dto.setId(entity.getId());
        dto.setStudentId(entity.getStudentId());
        dto.setCategory(entity.getCategory());
        dto.setDetail(entity.getDetail());
        dto.setResultDate(entity.getResultDate());
        return dto;
    }
}
