package com.example.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/users/**").permitAll()
                        .requestMatchers("/schedules/**").permitAll()
                        .requestMatchers("/messages/**").permitAll()
                        .requestMatchers("/attendance/**").permitAll()
                        .requestMatchers("/feedbacks/**").permitAll()
                        .requestMatchers("/announcements/**").permitAll()
                        .requestMatchers("/images/**").permitAll()
                        .requestMatchers("/study_comments/**").permitAll()
                        .requestMatchers("/study_results/**").permitAll()
                        .requestMatchers("/tuitions/**").permitAll()
                        .requestMatchers("/health/**").permitAll()
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
