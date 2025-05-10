package com.example.api.controller;

import com.example.api.model.Parent;
import com.example.api.service.ParentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parents")
@CrossOrigin(origins = "*")
public class ParentController {
    private final ParentService service;

    public ParentController(ParentService service) {
        this.service = service;
    }

    @GetMapping
    public List<Parent> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Parent getById(@PathVariable int id) {
        return service.getById(id).orElse(null);
    }

    @PostMapping
    public Parent create(@RequestBody Parent parent) {
        return service.create(parent);
    }

    @PutMapping("/{id}")
    public Parent update(@PathVariable int id, @RequestBody Parent parent) {
        return service.update(id, parent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
