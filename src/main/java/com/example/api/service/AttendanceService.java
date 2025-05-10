// src/main/java/com/example/api/service/AttendanceService.java
package com.example.api.service;

import com.example.api.dto.AttendanceDTO;
import com.example.api.model.Attendance;
import com.example.api.model.Student;
import com.example.api.repository.AttendanceRepository;
import com.example.api.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private StudentRepository studentRepository;  // ✨ thêm dòng này

    public List<AttendanceDTO> getAllAttendances() {
        return attendanceRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<AttendanceDTO> getAttendanceById(Long id) {
        return attendanceRepository.findById(id).map(this::convertToDTO);
    }

    public AttendanceDTO createAttendance(AttendanceDTO dto) {
        Attendance a = convertToEntity(dto);
        Attendance saved = attendanceRepository.save(a);
        return convertToDTO(saved);
    }

    public Optional<AttendanceDTO> updateAttendanceStatus(Long id, String status) {
        return attendanceRepository.findById(id).map(att -> {
            att.setStatus(status);
            attendanceRepository.save(att);
            return convertToDTO(att);
        });
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    private AttendanceDTO convertToDTO(Attendance a) {
        // tìm tên học sinh từ studentRepository
        String name = studentRepository.findById(a.getStudentId())
                .map(Student::getName)
                .orElse("Không rõ");
        return new AttendanceDTO(
                a.getId(),
                a.getStudentId(),
                a.getClassId(),
                name,                    // ✨ truyền studentName
                a.getStatus(),
                a.getDate(),
                a.getNote()
        );
    }

    private Attendance convertToEntity(AttendanceDTO dto) {
        return Attendance.builder()
                .id(dto.getId())
                .studentId(dto.getStudentId())
                .classId(dto.getClassId())
                .status(dto.getStatus())
                .date(dto.getDate())
                .note(dto.getNote())
                .build();
    }
}
