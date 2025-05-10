package com.example.api.service;

import com.example.api.model.Message;
import com.example.api.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    // 🔹 Lấy tất cả tin nhắn
    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    // 🔹 Lấy tin nhắn theo ID
    public Message getMessageById(Long id) {
        return messageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy tin nhắn với ID: " + id));
    }

    // 🔹 Lấy tin nhắn theo người nhận
    public List<Message> getMessagesByReceiver(Long receiverId) {
        return messageRepository.findByReceiverId(receiverId);
    }

    // 🔹 Lấy tin nhắn theo người gửi
    public List<Message> getMessagesBySender(Long senderId) {
        return messageRepository.findBySenderId(senderId);
    }

    // 🔹 Lấy tin nhắn theo trạng thái (Chưa xác nhận / Đã xác nhận)
    public List<Message> getMessagesByStatus(String status) {
        return messageRepository.findByStatus(status);
    }

    // 🔹 Thêm tin nhắn mới
    public Message createMessage(Message message) {
        message.setId(null); // ✅ Bắt buộc để tránh lỗi khi gửi ID từ client
        message.setCreatedAt(LocalDateTime.now()); // Gán thời gian tạo tin nhắn
        message.setStatus("Chưa xác nhận"); // Mặc định là chưa xác nhận
        return messageRepository.save(message);
    }

    // 🔹 Cập nhật nội dung hoặc ảnh của tin nhắn
    public Message updateMessage(Long id, Message updatedMessage) {
        return messageRepository.findById(id).map(message -> {
            message.setContent(updatedMessage.getContent());
            message.setImagePath(updatedMessage.getImagePath());
            message.setStatus(updatedMessage.getStatus());
            return messageRepository.save(message);
        }).orElseThrow(() -> new RuntimeException("Không tìm thấy tin nhắn với ID: " + id));
    }

    // 🔹 Cập nhật trạng thái tin nhắn (Đã xác nhận / Chưa xác nhận)
    public Message updateMessageStatus(Long id, boolean confirmed) {
        return messageRepository.findById(id).map(message -> {
            message.setStatus(confirmed ? "Đã xác nhận" : "Chưa xác nhận");
            return messageRepository.save(message);
        }).orElseThrow(() -> new RuntimeException("Không tìm thấy tin nhắn với ID: " + id));
    }

    // 🔹 Xóa tin nhắn
    public void deleteMessage(Long id) {
        if (!messageRepository.existsById(id)) {
            throw new RuntimeException("Không tìm thấy tin nhắn để xóa với ID: " + id);
        }
        messageRepository.deleteById(id);
    }
}
