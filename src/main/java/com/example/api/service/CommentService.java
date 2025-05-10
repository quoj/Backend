package com.example.api.service;

import com.example.api.dto.CommentDTO;
import com.example.api.model.Comment;
import com.example.api.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    // Lấy tất cả comment theo announcementId
    public List<CommentDTO> getCommentsByAnnouncementId(Long announcementId) {
        List<Comment> comments = commentRepository.findByAnnouncementId(announcementId);
        return comments.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    // Tạo mới comment
    public CommentDTO createComment(CommentDTO commentDTO) {
        Comment comment = convertToEntity(commentDTO);
        comment = commentRepository.save(comment);
        return convertToDTO(comment);
    }

    // Xoá comment theo id
    public void deleteComment(int id) {
        commentRepository.deleteById(id);
    }

    // Chuyển từ Entity sang DTO
    private CommentDTO convertToDTO(Comment comment) {
        CommentDTO dto = new CommentDTO();
        dto.setId(comment.getId());
        dto.setAnnouncementId(comment.getAnnouncementId());
        dto.setStudentId(comment.getStudentId());
        dto.setContent(comment.getContent());
        dto.setCreatedAt(comment.getCreatedAt());
        return dto;
    }

    // Chuyển từ DTO sang Entity
    private Comment convertToEntity(CommentDTO dto) {
        Comment comment = new Comment();
        comment.setAnnouncementId(dto.getAnnouncementId());
        comment.setStudentId(dto.getStudentId());
        comment.setContent(dto.getContent());
        return comment;
    }
}
