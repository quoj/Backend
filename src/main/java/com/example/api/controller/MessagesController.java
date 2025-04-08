package com.example.api.controller;

import com.example.api.model.Message;
import com.example.api.service.MessageService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/messages")
public class MessagesController {

    private final MessageService messageService;


    public MessagesController(MessageService messageService) {
        this.messageService = messageService;
    }

    // 🔹 API lấy danh sách tất cả lời nhắn
    @GetMapping
    public ResponseEntity<List<Message>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }

    // 🔹 API lấy chi tiết một lời nhắn theo ID
    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable Long id) {
        Message message = messageService.getMessageById(id);
        return ResponseEntity.ok(message);
    }


    // 🔹 API thêm lời nhắn mới
    @PostMapping
    public ResponseEntity<Message> createMessage(@RequestBody Message message) {
        Message savedMessage = messageService.createMessage(message);
        return ResponseEntity.ok(savedMessage);
    }

    // 🔹 API cập nhật trạng thái xác nhận lời nhắn
    @PutMapping("/{id}/confirm")
    public ResponseEntity<Message> confirmMessage(@PathVariable Long id, @RequestParam boolean confirmed) {
        Message updatedMessage = messageService.updateMessageStatus(id, confirmed);
        return ResponseEntity.ok(updatedMessage);
    }

    // 🔹 API xóa lời nhắn
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMessage(@PathVariable Long id) {
        messageService.deleteMessage(id);
        return ResponseEntity.noContent().build();
    }
}
