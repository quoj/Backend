package com.example.api.service;

import com.example.api.model.TuitionFee;
import com.example.api.repository.TuitionFeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TuitionFeeService {
    private final TuitionFeeRepository tuitionFeeRepository;

    public TuitionFeeService(TuitionFeeRepository tuitionFeeRepository) {
        this.tuitionFeeRepository = tuitionFeeRepository;
    }

    public List<TuitionFee> getAllTuitionFees() {
        return tuitionFeeRepository.findAll();
    }
    public TuitionFee addTuitionFee(TuitionFee tuitionFee) {
        return tuitionFeeRepository.save(tuitionFee);
    }

    public TuitionFee updateTuitionFee(Long id, TuitionFee tuitionFee) {
        Optional<TuitionFee> existingTuitionFee = tuitionFeeRepository.findById(id);
        if (existingTuitionFee.isPresent()) {
            TuitionFee updatedTuitionFee = existingTuitionFee.get();
            updatedTuitionFee.setAmount(tuitionFee.getAmount());
            updatedTuitionFee.setFeeType(tuitionFee.getFeeType());
            updatedTuitionFee.setDueDate(tuitionFee.getDueDate());
            return tuitionFeeRepository.save(updatedTuitionFee);
        }
        return null; // hoặc throw exception nếu không tìm thấy đối tượng
    }
    public TuitionFee getTuitionFeeById(Long id) {
        return tuitionFeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy khoản học phí với ID: " + id));
    }
}
