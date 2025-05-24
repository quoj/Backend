package com.example.api.controller;

import com.example.api.dto.ScheduleDTO;
import com.example.api.model.Schedule;
import com.example.api.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")


@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // Lấy tất cả lịch học
    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    // Thêm mới lịch học
    @PostMapping("/add")
    public ResponseEntity<Schedule> addSchedule(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.saveSchedule(schedule);
        return ResponseEntity.ok(savedSchedule);
    }

    // Lấy lịch học theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        return scheduleService.getScheduleById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Cập nhật lịch học theo ID
    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody Schedule schedule) {
        Optional<Schedule> existingSchedule = scheduleService.getScheduleById(id);
        if (existingSchedule.isPresent()) {
            schedule.setId(id);
            Schedule updatedSchedule = scheduleService.saveSchedule(schedule);
            return ResponseEntity.ok(updatedSchedule);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Xóa lịch học theo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        if (scheduleService.getScheduleById(id).isPresent()) {
            scheduleService.deleteSchedule(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    //Lấy tất cả lịch học theo classId và dayOfWeek (truyền dayOfWeek qua query param)
//    @GetMapping("/class/{classId}")
//    public ResponseEntity<List<ScheduleDTO>> getSchedulesByClassAndDay(
//            @PathVariable Long classId,
//            @RequestParam String dayOfWeek) {
//        List<ScheduleDTO> schedules = scheduleService.getSchedulesByClassAndDay(classId, dayOfWeek);
//        return ResponseEntity.ok(schedules);
//    }










    @PostMapping("/add-bulk")
    public ResponseEntity<?> addBulkSchedules(@RequestBody List<Schedule> schedules) {
        List<Schedule> savedSchedules = scheduleService.saveAllSchedules(schedules);
        return ResponseEntity.status(HttpStatus.OK).body(savedSchedules);
    }
    @DeleteMapping("/class/{classId}")
    public ResponseEntity<Void> deleteSchedulesByClassId(@PathVariable Long classId) {
        scheduleService.deleteSchedulesByClassId(classId);
        return ResponseEntity.noContent().build();
    }
}