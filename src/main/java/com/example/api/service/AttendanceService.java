package com.example.api.service;

import com.example.api.dto.AttendanceDTO;
import com.example.api.model.Attendance;
import com.example.api.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    // 🔹 Lấy danh sách điểm danh
    public List<AttendanceDTO> getAllAttendances() {
        return attendanceRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // 🔹 Lấy chi tiết điểm danh theo ID
    public Optional<AttendanceDTO> getAttendanceById(Long id) {
        return attendanceRepository.findById(id).map(this::convertToDTO);
    }

    // ✅ Sửa lỗi: Thêm phương thức createAttendance
    public AttendanceDTO createAttendance(AttendanceDTO attendanceDTO) {
        Attendance attendance = convertToEntity(attendanceDTO);
        Attendance savedAttendance = attendanceRepository.save(attendance);
        return convertToDTO(savedAttendance);
    }

    // 🔹 Cập nhật trạng thái điểm danh
    public Optional<AttendanceDTO> updateAttendanceStatus(Long id, String status) {
        return attendanceRepository.findById(id).map(attendance -> {
            attendance.setStatus(status);
            attendanceRepository.save(attendance);
            return convertToDTO(attendance);
        });
    }

    // 🔹 Xóa điểm danh
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    // ✅ Chuyển đổi từ Model -> DTO
    private AttendanceDTO convertToDTO(Attendance attendance) {
        return new AttendanceDTO(attendance.getId(), attendance.getStudentId(), attendance.getStatus(), attendance.getDate(), attendance.getNote());
    }

    // ✅ Chuyển đổi từ DTO -> Model
    private Attendance convertToEntity(AttendanceDTO attendanceDTO) {
        return new Attendance(attendanceDTO.getId(), attendanceDTO.getStudentId(), attendanceDTO.getStatus(), attendanceDTO.getDate(), attendanceDTO.getNote());
    }
}
