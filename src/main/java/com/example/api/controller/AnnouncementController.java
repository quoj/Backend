package com.example.api.controller;

import com.example.api.dto.AnnouncementDTO;
import com.example.api.model.Announcement;
import com.example.api.service.AnnouncementService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/announcements")
public class AnnouncementController {

    private final AnnouncementService service;

    public AnnouncementController(AnnouncementService service) {
        this.service = service;
    }

    @GetMapping
    public List<Announcement> getAll() {
        return service.getAllAnnouncements();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Announcement> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getAnnouncementById(id));
    }

    @PostMapping
    public ResponseEntity<Announcement> create(@RequestBody AnnouncementDTO dto) {
        return ResponseEntity.ok(service.createAnnouncement(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Announcement> update(@PathVariable Long id, @RequestBody AnnouncementDTO dto) {
        return ResponseEntity.ok(service.updateAnnouncement(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.deleteAnnouncement(id);
        return ResponseEntity.noContent().build();
    }
}
