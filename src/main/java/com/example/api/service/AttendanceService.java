package com.example.api.service;

import com.example.api.dto.AttendanceDTO;
import com.example.api.model.Attendance;
import com.example.api.repository.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    // ✅ SỬA ở đây
    public Attendance saveAttendance(Attendance attendance) {
        Optional<Attendance> existing = attendanceRepository.findByStudentAndDate(
                attendance.getStudent(),
                attendance.getDate()
        );

        if (existing.isPresent()) {
            Attendance old = existing.get();
            old.setStatus(attendance.getStatus());
            old.setTime(attendance.getTime());
            return attendanceRepository.save(old);
        }

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAttendancesByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

}
