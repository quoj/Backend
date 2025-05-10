package com.example.api.service;

import com.example.api.dto.MenuDTO;
import com.example.api.model.Menu;
import com.example.api.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    private MenuRepository menuRepository;

    public List<MenuDTO> getAllMenus() {
        return menuRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<MenuDTO> getMenuByDate(LocalDate date) {
        return menuRepository.findByDate(date).map(this::toDTO);
    }

    private MenuDTO toDTO(Menu menu) {
        MenuDTO dto = new MenuDTO();
        dto.setId(menu.getId());
        dto.setDate(menu.getDate());
        dto.setBreakfast(menu.getBreakfast());
        dto.setLunch(menu.getLunch());
        dto.setDinner(menu.getDinner());
        dto.setCreatedAt(menu.getCreatedAt());  // Thêm chuyển đổi created_at
        return dto;
    }
}
