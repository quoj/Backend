package com.example.api.controller;

import com.example.api.dto.MenuDTO;
import com.example.api.model.Menu;
import com.example.api.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menus")
@CrossOrigin("*")
//@CrossOrigin("*")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping
    public List<MenuDTO> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/by-day-of-week")
    public List<MenuDTO> getMenusByDayOfWeek(@RequestParam("day") String dayOfWeek) {
        return menuService.getMenusByDayOfWeek(dayOfWeek);
    }

    @GetMapping("/by-date")
    public Optional<MenuDTO> getMenuByDate(@RequestParam("date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return menuService.getMenuByDate(date);
    }

    @PostMapping
    public List<MenuDTO> createMenus(@RequestBody List<MenuDTO> menuDTOList) {
        return menuService.createMenus(menuDTOList);
    }

    @PostMapping("/bulk-save")
    public ResponseEntity<List<Menu>> addMultipleMenus(@RequestBody List<MenuDTO> menuDTOs) {
        List<Menu> savedMenus = menuService.saveMultipleMenus(menuDTOs);
        return ResponseEntity.ok(savedMenus);
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<Void> deleteAllMenus() {
        menuService.deleteAllMenus();
        return ResponseEntity.noContent().build();
    }

}
