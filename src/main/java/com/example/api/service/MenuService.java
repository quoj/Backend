package com.example.api.service;

import com.example.api.dto.MenuDTO;
import com.example.api.model.Menu;
import com.example.api.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
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

    public MenuDTO createMenu(MenuDTO dto) {
        Menu menu = new Menu();
        menu.setDayOfWeek(dto.getDayOfWeek());
        menu.setDate(dto.getDate());
        menu.setBreakfast(dto.getBreakfast());
        menu.setSecond_breakfast(dto.getSecond_breakfast());
        menu.setLunch(dto.getLunch());
        menu.setDinner(dto.getDinner());
        menu.setSecond_dinner(dto.getSecond_dinner());
        Menu saved = menuRepository.save(menu);
        return toDTO(saved);
    }

    public List<MenuDTO> createMenus(List<MenuDTO> menuDTOs) {
        List<Menu> menus = new ArrayList<>();

        for (MenuDTO dto : menuDTOs) {
            Menu menu = new Menu();
            menu.setDayOfWeek(dto.getDayOfWeek());
            menu.setDate(dto.getDate());
            menu.setBreakfast(dto.getBreakfast());
            menu.setSecond_breakfast(dto.getSecond_breakfast());
            menu.setLunch(dto.getLunch());
            menu.setDinner(dto.getDinner());
            menu.setSecond_dinner(dto.getSecond_dinner());
            menus.add(menu);
        }

        List<Menu> savedMenus = menuRepository.saveAll(menus);

        return savedMenus.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private MenuDTO toDTO(Menu menu) {
        MenuDTO dto = new MenuDTO();
        dto.setId(menu.getId());
        dto.setDayOfWeek(menu.getDayOfWeek());
        dto.setDate(menu.getDate());
        dto.setBreakfast(menu.getBreakfast());
        dto.setSecond_breakfast(menu.getSecond_breakfast());
        dto.setLunch(menu.getLunch());
        dto.setDinner(menu.getDinner());
        dto.setSecond_dinner(menu.getSecond_dinner());
        dto.setCreatedAt(menu.getCreatedAt());
        return dto;
    }

    public List<Menu> saveMultipleMenus(List<MenuDTO> menuDTOs) {
        List<Menu> menus = menuDTOs.stream().map(dto -> {
            Menu menu = new Menu();
            menu.setDayOfWeek(dto.getDayOfWeek());
            menu.setDate(dto.getDate());
            menu.setBreakfast(dto.getBreakfast());
            menu.setSecond_breakfast(dto.getSecond_breakfast());
            menu.setLunch(dto.getLunch());
            menu.setDinner(dto.getDinner());
            menu.setSecond_dinner(dto.getSecond_dinner());
            return menu;
        }).collect(Collectors.toList());

        return menuRepository.saveAll(menus);
    }

    public void deleteAllMenus() {
        menuRepository.deleteAll();
    }

    public List<MenuDTO> getMenusByDayOfWeek(String dayOfWeek) {
        return menuRepository.findByDayOfWeek(dayOfWeek)
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

}



