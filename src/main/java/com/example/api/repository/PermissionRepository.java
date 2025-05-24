package com.example.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.api.model.Permission;;


public interface PermissionRepository extends JpaRepository<Permission, Long> {
    Permission findByPermission(String permission);

}
