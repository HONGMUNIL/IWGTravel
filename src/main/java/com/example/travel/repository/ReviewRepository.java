package com.example.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travel.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
