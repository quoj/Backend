package com.example.api.service;

import com.example.api.dto.StudentDTO;
import com.example.api.model.Student;
import com.example.api.model.SchoolClass;

import com.example.api.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student saveStudent(StudentDTO studentDTO) {
        Student student = new Student();
        student.setName(studentDTO.getName());
        student.setGender(studentDTO.getGender());
        student.setAddress(studentDTO.getAddress());
        student.setEmail(studentDTO.getEmail());
        student.setDob(studentDTO.getDob());
        student.setDad(studentDTO.getDad());
        student.setMom(studentDTO.getMom());
        student.setPhoneDad(studentDTO.getPhoneDad());
        student.setPhoneMom(studentDTO.getPhoneMom());

        // Set Class cho Student nếu classId khác null
        if (studentDTO.getClassId() != null) {
            SchoolClass clazz = new SchoolClass();
            clazz.setId(studentDTO.getClassId());
            student.setClassId(clazz);
        } else {
            student.setClassId(null);
        }

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }


    public void deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
        } else {
            throw new RuntimeException("Student not found with id " + id);
        }
    }

    public Optional<Student> updateStudent(Long id, StudentDTO studentDTO) {
        return studentRepository.findById(id).map(student -> {
            student.setName(studentDTO.getName());
            student.setGender(studentDTO.getGender());
            student.setAddress(studentDTO.getAddress());
            student.setEmail(studentDTO.getEmail());
            student.setDob(studentDTO.getDob());
            student.setDad(studentDTO.getDad());
            student.setMom(studentDTO.getMom());
            student.setPhoneDad(studentDTO.getPhoneDad());
            student.setPhoneMom(studentDTO.getPhoneMom());

            if (studentDTO.getClassId() != null) {
                SchoolClass clazz = new SchoolClass();
                clazz.setId(studentDTO.getClassId());
                student.setClassId(clazz);
            } else {
                student.setClassId(null);
            }

            return studentRepository.save(student);
        });
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }



}