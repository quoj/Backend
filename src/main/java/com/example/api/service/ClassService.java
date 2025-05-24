package com.example.api.service;

import com.example.api.dto.ClassDTO;
import com.example.api.model.SchoolClass;
import com.example.api.repository.ClassRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassService {
    private final ClassRepository classRepository;

    public ClassService(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    public List<SchoolClass> getAllClass() {
        return classRepository.findAll();
    }

    public SchoolClass createClass(ClassDTO classDTO) {
        SchoolClass aClass = new SchoolClass();
        aClass.setName(classDTO.getName());
        aClass.setGrade(classDTO.getGrade());
        return classRepository.save(aClass); // <-- Save vào DB luôn
    }

    public SchoolClass updateClass(Long id, ClassDTO classDTO) {
        Optional<SchoolClass> optionalClass = classRepository.findById(id);
        if (optionalClass.isPresent()) {
            SchoolClass existingClass = optionalClass.get();
            existingClass.setName(classDTO.getName());
            existingClass.setGrade(classDTO.getGrade());
            return classRepository.save(existingClass);
        } else {
            throw new RuntimeException("Class not found with id: " + id);
        }
    }

    public void deleteClass(Long id) {
        classRepository.deleteById(id);
    }

    public Optional<SchoolClass> getClassById(Long id) {
        return classRepository.findById(id);
    }
}
