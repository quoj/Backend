package com.example.api.service;

import com.example.api.dto.ScheduleDTO;
import com.example.api.model.Schedule;
import com.example.api.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;

    // Chuyển đổi từ Entity sang DTO
    private ScheduleDTO convertToDTO(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(schedule.getId());
        dto.setClassId(schedule.getClassId());
        dto.setSubjectId(schedule.getSubjectId());
        dto.setTeacherId(schedule.getTeacherId());
        dto.setDayOfWeek(schedule.getDayOfWeek());
        dto.setStartTime(schedule.getStartTime());
        dto.setEndTime(schedule.getEndTime());
        return dto;
    }

    // Lấy tất cả thời khóa biểu
    public List<ScheduleDTO> getAllSchedules() {
        return scheduleRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Lấy thời khóa biểu theo ID
    public Optional<ScheduleDTO> getScheduleById(Long id) {
        return scheduleRepository.findById(id).map(this::convertToDTO);
    }

    // Thêm thời khóa biểu mới
    public ScheduleDTO addSchedule(Schedule schedule) {
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return convertToDTO(savedSchedule);
    }

    // Cập nhật thời khóa biểu
    public ScheduleDTO updateSchedule(Long id, Schedule updatedSchedule) {
        return scheduleRepository.findById(id).map(schedule -> {
            schedule.setClassId(updatedSchedule.getClassId());
            schedule.setSubjectId(updatedSchedule.getSubjectId());
            schedule.setTeacherId(updatedSchedule.getTeacherId());
            schedule.setDayOfWeek(updatedSchedule.getDayOfWeek());
            schedule.setStartTime(updatedSchedule.getStartTime());
            schedule.setEndTime(updatedSchedule.getEndTime());
            return convertToDTO(scheduleRepository.save(schedule));
        }).orElse(null);
    }

    // Xóa thời khóa biểu theo ID
    public boolean deleteSchedule(Long id) {
        if (scheduleRepository.existsById(id)) {
            scheduleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
