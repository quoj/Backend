package com.example.api.repository;

import com.example.api.model.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    // Bạn có thể thêm các phương thức truy vấn tùy chỉnh nếu cần
}
