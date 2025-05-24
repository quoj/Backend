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

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    // Lưu hoặc cập nhật lịch học
    public Schedule saveSchedule(Schedule schedule) {
        return scheduleRepository.save(schedule);
    }

    // Lấy tất cả lịch học cho lớp học và ngày cụ thể
//    public List<ScheduleDTO> getSchedulesByClassAndDay(Long classId, String dayOfWeek) {
//        List<Schedule> schedules = scheduleRepository. findByClazzIdAndDayOfWeek(classId, dayOfWeek);
//
//        return schedules.stream().map(schedule -> {
//            ScheduleDTO scheduleDTO = new ScheduleDTO();
//            scheduleDTO.setId(schedule.getId());
//            scheduleDTO.setClassId(schedule.getClazz().getId());
//            scheduleDTO.setSubjectId(schedule.getSubjectId());
//            scheduleDTO.setTeacherId(schedule.getTeacherId());
//            scheduleDTO.setDayOfWeek(schedule.getDayOfWeek());
//            scheduleDTO.setStartTime(schedule.getStartTime());
//            scheduleDTO.setEndTime(schedule.getEndTime());
//            return scheduleDTO;
//        }).collect(Collectors.toList());
//    }













    // Lấy lịch học theo ID
    public Optional<Schedule> getScheduleById(Long id) {
        return scheduleRepository.findById(id);
    }

    // Xóa lịch học theo ID
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }

    // Lấy tất cả lịch học
    public List<Schedule> getAllSchedules() {
        return scheduleRepository.findAll();
    }

    public List<Schedule> saveAllSchedules(List<Schedule> schedules) {
        return scheduleRepository.saveAll(schedules);
    }
    public void deleteSchedulesByClassId(Long classId) {
        scheduleRepository.deleteByClazzId(classId);
    }
}
