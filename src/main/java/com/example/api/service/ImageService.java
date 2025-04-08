package com.example.api.service;

import com.example.api.model.Image;
import com.example.api.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {

    private final ImageRepository imageRepository;

    public ImageService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    // Phương thức upload ảnh và trả về Image entity
    public Image uploadImage(Long announcementId, MultipartFile image) throws IOException {
        // Tạo một thực thể Image
        Image imageEntity = new Image();
        imageEntity.setAnnouncementId(announcementId);
        imageEntity.setImageData(image.getBytes());  // Lưu ảnh dưới dạng byte array

        return imageRepository.save(imageEntity); // Lưu ảnh vào cơ sở dữ liệu
    }

    // Phương thức lấy ảnh theo ID
    public Image getImage(Long imageId) {
        Optional<Image> imageOptional = imageRepository.findById(imageId);
        if (imageOptional.isEmpty()) {
            throw new RuntimeException("Không tìm thấy ảnh!");
        }
        return imageOptional.get();
    }
}
