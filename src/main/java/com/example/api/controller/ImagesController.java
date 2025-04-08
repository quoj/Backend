package com.example.api.controller;

import com.example.api.dto.ImageDTO;
import com.example.api.model.Image;
import com.example.api.service.ImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/images")
public class ImagesController {

    private final ImageService imageService;

    public ImagesController(ImageService imageService) {
        this.imageService = imageService;
    }

    // Endpoint để upload ảnh và trả về ImageDTO
    @PostMapping("/upload/{announcementId}")
    public ResponseEntity<ImageDTO> uploadImage(@PathVariable Long announcementId,
                                                @RequestParam("image") MultipartFile image) throws IOException {
        Image imageEntity = imageService.uploadImage(announcementId, image);
        String imageUrl = "/images/" + imageEntity.getId();  // Đường dẫn ảnh sau khi upload

        ImageDTO imageDTO = new ImageDTO(imageEntity.getId(), imageEntity.getAnnouncementId(), imageUrl, null);
        return ResponseEntity.ok(imageDTO);
    }

    // Endpoint để lấy ảnh và trả về image dưới dạng byte[] (ảnh nhị phân)
    @GetMapping("/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable Long imageId) {
        Image image = imageService.getImage(imageId);

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"image.jpg\"")
                .contentType(MediaType.IMAGE_JPEG)
                .body(image.getImageData());
    }
}
