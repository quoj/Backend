package com.example.api.controller;

import com.example.api.dto.ProgramDTO;
import com.example.api.model.Programs;
import com.example.api.service.ProgramService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/programs")
public class ProgramController {

    private final ProgramService programService;

    public ProgramController(ProgramService programService) {
        this.programService = programService;
    }

    @GetMapping
    public List<ProgramDTO> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @PostMapping(value = "/add", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Programs createProgram(
            @RequestParam("program") String programJson,  // Nhận chương trình dưới dạng JSON
            @RequestParam(value = "image", required = false) MultipartFile image // Nhận ảnh
    ) throws IOException {
        // Chuyển JSON sang đối tượng Programs
        ObjectMapper objectMapper = new ObjectMapper();
        Programs program = objectMapper.readValue(programJson, Programs.class);

        // Nếu có ảnh, đọc vào byte[] và gán vào entity
        if (image != null && !image.isEmpty()) {
            byte[] imageBytes = image.getBytes();
            program.setImage(imageBytes); // Đặt ảnh vào entity
        }

        return programService.createProgram(program); // Lưu vào database
    }
}
