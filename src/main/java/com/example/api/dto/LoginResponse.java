package com.example.api.dto;

import java.util.List;

public class LoginResponse {
    private String token;
    private List<String> roles; // Thêm dòng này

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    // Getter và Setter cho roles
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
