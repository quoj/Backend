package com.example.api.repository;

import com.example.api.model.Schedule;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    //List<Schedule>findByClazzIdAndDayOfWeek(Long classId, String dayOfWeek);
    @Transactional
    @Modifying
    void deleteByClazzId(Long classId);
}

