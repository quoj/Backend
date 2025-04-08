package com.example.api.service;

import com.example.api.model.Feedback;
import com.example.api.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public List<Feedback> getAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> getFeedbackById(Long id) {
        return feedbackRepository.findById(id);
    }

    public Feedback saveFeedback(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    public Optional<Feedback> updateFeedbackStatus(Long id, String status) {
        return feedbackRepository.findById(id).map(feedback -> {
            feedback.setStatus(status);
            return feedbackRepository.save(feedback);
        });
    }

    public void deleteFeedback(Long id) {
        feedbackRepository.deleteById(id);
    }
}
