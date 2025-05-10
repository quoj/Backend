package com.example.api.controller;

import com.example.api.dto.StudentDTO;
import com.example.api.model.Student;
import com.example.api.model.Student.AttendanceStatus;
import com.example.api.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Student> getAll() {
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getById(@PathVariable Long id) {
        Student student = service.getStudentById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody StudentDTO dto) {
        Student student = service.createStudent(dto);
        return ResponseEntity.ok(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody StudentDTO dto) {
        Student student = service.updateStudent(id, dto);
        return ResponseEntity.ok(student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }

    // API cập nhật trạng thái điểm danh (present / absent)
    @PatchMapping("/{id}/attendance-status")
    public ResponseEntity<Student> updateAttendanceStatus(
            @PathVariable Long id,
            @RequestParam("status") AttendanceStatus status
    ) {
        Student student = service.updateAttendanceStatus(id, status);
        return ResponseEntity.ok(student);
    }
}
