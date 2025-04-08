package com.example.api.service;

import com.example.api.dto.AnnouncementDTO;
import com.example.api.model.Announcement;
import com.example.api.repository.AnnouncementRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnnouncementService {

    private final AnnouncementRepository repository;

    public AnnouncementService(AnnouncementRepository repository) {
        this.repository = repository;
    }

    public List<Announcement> getAllAnnouncements() {
        return repository.findAll();
    }

    public Announcement getAnnouncementById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Không tìm thấy!"));
    }

    // 🔥 Thêm phương thức createAnnouncement()
    public Announcement createAnnouncement(AnnouncementDTO dto) {
        Announcement announcement = new Announcement();
        announcement.setTitle(dto.getTitle());
        announcement.setAuthor(dto.getAuthor());
        announcement.setContent(dto.getContent());
        announcement.setImagePath(dto.getImagePath());
        announcement.setCreatedAt(LocalDateTime.now()); // Lưu thời gian tạo

        return repository.save(announcement);
    }

    public Announcement updateAnnouncement(Long id, AnnouncementDTO dto) {
        Announcement announcement = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy!"));

        announcement.setTitle(dto.getTitle());
        announcement.setAuthor(dto.getAuthor());
        announcement.setContent(dto.getContent());
        announcement.setImagePath(dto.getImagePath());

        return repository.save(announcement);
    }

    public void deleteAnnouncement(Long id) {
        repository.deleteById(id);
    }
}
