package com.example.travel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.travel.entity.Review;
import com.example.travel.repository.ReviewRepository;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

  
    public void saveReview(Review review) {
        reviewRepository.save(review);
    }
}
