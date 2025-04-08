package com.example.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageDTO {
    private Long id;              // ID của ảnh
    private Long announcementId;  // ID của thông báo (để liên kết ảnh với thông báo)
    private String imageUrl;      // Đường dẫn ảnh nếu lưu ảnh ở một URL
    private byte[] imageData;     // Dữ liệu ảnh (nếu muốn trả về ảnh dưới dạng byte array)
}
