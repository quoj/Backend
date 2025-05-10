package com.example.api.service;

import com.example.api.dto.TeacherDTO;
import com.example.api.model.Teacher;
import com.example.api.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    // Chuyển Entity sang DTO
    private TeacherDTO toDTO(Teacher teacher) {
        TeacherDTO dto = new TeacherDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setPhone(teacher.getPhone());
        dto.setEmail(teacher.getEmail());
        dto.setSubjectId(teacher.getSubjectId());
        dto.setDepartment(teacher.getDepartment());
        return dto;
    }

    // Chuyển DTO sang Entity
    private Teacher toEntity(TeacherDTO dto) {
        Teacher teacher = new Teacher();
        teacher.setId(dto.getId());
        teacher.setName(dto.getName());
        teacher.setPhone(dto.getPhone());
        teacher.setEmail(dto.getEmail());
        teacher.setSubjectId(dto.getSubjectId());
        teacher.setDepartment(dto.getDepartment());
        return teacher;
    }

    public List<TeacherDTO> getAllTeachers() {
        return teacherRepository.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    public Optional<TeacherDTO> getTeacherById(Long id) {
        return teacherRepository.findById(id).map(this::toDTO);
    }

    public TeacherDTO addTeacher(TeacherDTO dto) {
        Teacher saved = teacherRepository.save(toEntity(dto));
        return toDTO(saved);
    }

    public TeacherDTO updateTeacher(Long id, TeacherDTO dto) {
        if (teacherRepository.existsById(id)) {
            Teacher teacher = toEntity(dto);
            teacher.setId(id);
            Teacher updated = teacherRepository.save(teacher);
            return toDTO(updated);
        }
        return null;
    }

    public boolean deleteTeacher(Long id) {
        if (teacherRepository.existsById(id)) {
            teacherRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
