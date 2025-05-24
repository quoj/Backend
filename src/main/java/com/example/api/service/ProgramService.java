package com.example.api.service;

import com.example.api.dto.ProgramDTO;
import com.example.api.model.Programs;
import com.example.api.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProgramService {

    private final ProgramRepository programRepository;

    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    // Lấy danh sách tất cả các chương trình và chuyển sang DTO
    public List<ProgramDTO> getAllPrograms() {
        List<Programs> programs = programRepository.findAll();
        return programs.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Chuyển từ entity sang DTO, chuyển ảnh thành base64
    private ProgramDTO convertToDTO(Programs program) {
        ProgramDTO dto = new ProgramDTO();
        dto.setId(program.getId());
        dto.setProgramName(program.getProgramName());
        dto.setProgramDescription(program.getProgramDescription());
        dto.setTotalSessions(program.getTotalSessions());
        dto.setTuition(program.getTuition());

        try {
            byte[] imageBytes = program.getImage(); // Đã được giải nén bên trong entity
            if (imageBytes != null && imageBytes.length > 0) {
                String base64Image = Base64.getEncoder().encodeToString(imageBytes);
                dto.setImageBase64(base64Image);
            }
        } catch (Exception e) {
            dto.setImageBase64(null); // Nếu có lỗi, trả về null cho imageBase64
        }

        return dto;
    }

    // Lưu entity chương trình
    public Programs createProgram(Programs program) {
        return programRepository.save(program);
    }
}
