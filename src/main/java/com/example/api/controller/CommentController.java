package com.example.api.controller;

import com.example.api.dto.CommentDTO;
import com.example.api.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // Lấy tất cả comment theo announcement_id
    @GetMapping("/announcement/{id}")
    public List<CommentDTO> getCommentsByAnnouncementId(@PathVariable Long id) {
        return commentService.getCommentsByAnnouncementId(id);
    }

    // Tạo comment mới
    @PostMapping
    public CommentDTO createComment(@RequestBody CommentDTO commentDTO) {
        return commentService.createComment(commentDTO);
    }

    // Xoá comment theo ID (tuỳ chọn)
    @DeleteMapping("/{id}")
    public void deleteComment(@PathVariable int id) {
        commentService.deleteComment(id);
    }
}
