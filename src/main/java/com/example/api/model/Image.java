package com.example.api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "images")
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long announcementId; // ID của thông báo liên quan

    @Lob
    @Column(name = "image_data")
    private byte[] imageData; // Dữ liệu ảnh lưu dưới dạng byte array

    // Bạn có thể thêm thêm các thuộc tính khác nếu cần (ví dụ: tên ảnh, loại ảnh...)
}
