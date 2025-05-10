package com.example.api.service;

import com.example.api.dto.NotificationDTO;
import com.example.api.model.Notification;
import com.example.api.repository.NotificationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> getAll() {
        return repository.findAll();
    }

    public Notification getById(Long id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Notification not found"));
    }

    public Notification create(NotificationDTO dto) {
        Notification notification = new Notification();
        notification.setTitle(dto.getTitle());
        notification.setContent(dto.getContent());
        notification.setClassId(dto.getClassId());
        return repository.save(notification);
    }

    public Notification update(Long id, NotificationDTO dto) {
        Notification existing = getById(id);
        existing.setTitle(dto.getTitle());
        existing.setContent(dto.getContent());
        existing.setClassId(dto.getClassId());
        return repository.save(existing);
    }

    public void delete(Long id) {
        Notification existing = getById(id);
        repository.delete(existing);
    }

    public List<Notification> getByClassId(Integer classId) {
        return repository.findByClassId(classId);
    }
}
