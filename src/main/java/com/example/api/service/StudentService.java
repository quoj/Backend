package com.example.api.service;

import com.example.api.dto.StudentDTO;
import com.example.api.model.Student;
import com.example.api.model.Student.AttendanceStatus;
import com.example.api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student with id " + id + " not found"));
    }

    public Student createStudent(StudentDTO dto) {
        Student student = new Student();
        mapDtoToEntity(dto, student);
        return repository.save(student);
    }

    public Student updateStudent(Long id, StudentDTO dto) {
        Student student = getStudentById(id);
        mapDtoToEntity(dto, student);
        return repository.save(student);
    }

    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }

    public Student updateAttendanceStatus(Long id, AttendanceStatus status) {
        Student student = getStudentById(id);
        student.setAttendanceStatus(status);
        return repository.save(student);
    }

    private void mapDtoToEntity(StudentDTO dto, Student student) {
        student.setName(dto.getName());
        student.setDob(dto.getDob());
        student.setGender(dto.getGender());
        student.setAddress(dto.getAddress());
        student.setPhone(dto.getPhone());
        student.setEmail(dto.getEmail());
        student.setClassId(dto.getClassId());
        student.setAttendanceStatus(dto.getAttendanceStatus());
    }
}
