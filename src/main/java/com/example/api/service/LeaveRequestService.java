package com.example.api.service;

import com.example.api.dto.LeaveRequestDTO;
import com.example.api.model.LeaveRequest;
import com.example.api.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    public List<LeaveRequest> getAllLeaveRequests() {
        return leaveRequestRepository.findAll();
    }

    public Optional<LeaveRequest> getLeaveRequestById(Long id) {
        return leaveRequestRepository.findById(id);
    }

    public LeaveRequest createLeaveRequest(LeaveRequestDTO dto) {
        LeaveRequest leaveRequest = new LeaveRequest(
                dto.getStudentId(),
                dto.getReason(),
                dto.getDate(),
                dto.getStatus()
        );
        return leaveRequestRepository.save(leaveRequest);
    }

    public LeaveRequest updateLeaveRequestStatus(Long id, String status) {
        Optional<LeaveRequest> optional = leaveRequestRepository.findById(id);
        if (optional.isPresent()) {
            LeaveRequest leaveRequest = optional.get();
            leaveRequest.setStatus(status);
            return leaveRequestRepository.save(leaveRequest);
        }
        return null;
    }

    public void deleteLeaveRequest(Long id) {
        leaveRequestRepository.deleteById(id);
    }
}
