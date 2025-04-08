    package com.example.api.controller;

    import com.example.api.dto.ScheduleDTO;
    import com.example.api.model.Schedule;
    import com.example.api.service.ScheduleService;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    import java.util.Optional;

    @CrossOrigin(origins = "*")
    @RestController
    @RequestMapping("schedules")
    public class ScheduleController {

        @Autowired
        private ScheduleService scheduleService;

        // Lấy tất cả thời khóa biểu
        @GetMapping
        public ResponseEntity<List<ScheduleDTO>> getAllSchedules() {
            List<ScheduleDTO> schedules = scheduleService.getAllSchedules();
            return ResponseEntity.ok(schedules);
        }

        // Lấy thời khóa biểu theo ID
        @GetMapping("/{id}")
        public ResponseEntity<ScheduleDTO> getScheduleById(@PathVariable Long id) {
            Optional<ScheduleDTO> schedule = scheduleService.getScheduleById(id);
            return schedule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Thêm mới thời khóa biểu
        @PostMapping
        public ResponseEntity<ScheduleDTO> addSchedule(@RequestBody Schedule schedule) {
            ScheduleDTO newSchedule = scheduleService.addSchedule(schedule);
            return ResponseEntity.ok(newSchedule);
        }

        // Cập nhật thời khóa biểu
        @PutMapping("/{id}")
        public ResponseEntity<ScheduleDTO> updateSchedule(@PathVariable Long id, @RequestBody Schedule updatedSchedule) {
            ScheduleDTO schedule = scheduleService.updateSchedule(id, updatedSchedule);
            return schedule != null ? ResponseEntity.ok(schedule) : ResponseEntity.notFound().build();
        }
    }
