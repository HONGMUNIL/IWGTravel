package com.example.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travel.entity.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
