package com.example.api.service;

import com.example.api.model.Parent;
import com.example.api.repository.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParentService {
    private final ParentRepository repository;

    public ParentService(ParentRepository repository) {
        this.repository = repository;
    }

    public List<Parent> getAll() {
        return repository.findAll();
    }

    public Optional<Parent> getById(int id) {
        return repository.findById(id);
    }

    public Parent create(Parent parent) {
        return repository.save(parent);
    }

    public Parent update(int id, Parent updated) {
        return repository.findById(id).map(p -> {
            p.setName(updated.getName());
            p.setPhone(updated.getPhone());
            p.setEmail(updated.getEmail());
            p.setRelationship(updated.getRelationship());
            p.setStudentId(updated.getStudentId());
            return repository.save(p);
        }).orElse(null);
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
