package com.example.api.controller;

import com.example.api.dto.ImageDTO;
import com.example.api.model.Image;
import com.example.api.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
public class ImagesController {

    @Autowired
    private ImageService imageService;

    @GetMapping
    public List<Image> getAllImages() {
        return imageService.getAllImages();
    }

    @GetMapping("/{id}")
    public Optional<Image> getImageById(@PathVariable Long id) {
        return imageService.getImageById(id);
    }

    @PostMapping
    public Image saveImage(@RequestBody Image image) {
        return imageService.saveImage(image);
    }

    @DeleteMapping("/{id}")
    public void deleteImage(@PathVariable Long id) {
        imageService.deleteImage(id);
    }
}
