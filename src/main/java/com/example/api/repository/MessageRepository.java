package com.example.api.repository;

import com.example.api.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    // Lấy danh sách tin nhắn theo người nhận (receiverId)
    List<Message> findByReceiverId(Long receiverId);

    // Lấy danh sách tin nhắn theo người gửi (senderId)
    List<Message> findBySenderId(Long senderId);

    // Lấy danh sách tin nhắn theo trạng thái
    List<Message> findByStatus(String status);
}
