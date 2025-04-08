package com.example.api.service;

import com.example.api.dto.StudyCommentDTO;
import com.example.api.model.Student;
import com.example.api.model.StudyComment;
import com.example.api.repository.StudentRepository;
import com.example.api.repository.StudyCommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudyCommentService {

    @Autowired
    private StudyCommentRepository repository;

    @Autowired
    private StudentRepository studentRepository;

    public List<StudyCommentDTO> getAllStudyCommentDTOs() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public StudyCommentDTO getStudyCommentDTOById(Long id) {
        return convertToDTO(getStudyCommentById(id));
    }

    private StudyCommentDTO convertToDTO(StudyComment comment) {
        StudyCommentDTO dto = new StudyCommentDTO();
        dto.setId(comment.getId());

        // 💥 In log nếu student bị null
        if (comment.getStudent() == null) {
            System.out.println("⚠️ Student null trong comment ID: " + comment.getId());
        }

        dto.setStudentId(comment.getStudent() != null ? comment.getStudent().getId() : null);
        dto.setCommentType(comment.getCommentType());
        dto.setCommentText(comment.getCommentText());
        dto.setCommentDate(comment.getCommentDate());
        return dto;
    }


    private StudyComment getStudyCommentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy nhận xét với ID: " + id));
    }

    public StudyCommentDTO createStudyComment(StudyCommentDTO dto) {
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy học sinh với ID: " + dto.getStudentId()));

        StudyComment studyComment = new StudyComment();
        studyComment.setStudent(student);
        studyComment.setCommentType(dto.getCommentType());
        studyComment.setCommentText(dto.getCommentText());
        studyComment.setCommentDate(dto.getCommentDate());

        return convertToDTO(repository.save(studyComment));
    }

    public StudyCommentDTO updateStudyComment(Long id, StudyCommentDTO dto) {
        StudyComment studyComment = getStudyCommentById(id);
        Student student = studentRepository.findById(dto.getStudentId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy học sinh với ID: " + dto.getStudentId()));

        studyComment.setStudent(student);
        studyComment.setCommentType(dto.getCommentType());
        studyComment.setCommentText(dto.getCommentText());
        studyComment.setCommentDate(dto.getCommentDate());

        return convertToDTO(repository.save(studyComment));
    }

    public void deleteStudyComment(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy nhận xét để xóa với ID: " + id);
        }
        repository.deleteById(id);
    }
}
