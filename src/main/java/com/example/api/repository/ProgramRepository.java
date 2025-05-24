package com.example.api.repository;

import com.example.api.model.Programs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProgramRepository extends JpaRepository<Programs, Long> {

}
