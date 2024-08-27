package com.example.travel.repository.PhotoRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.travel.model.Photo;

public interface PhotoRepository extends JpaRepository<Photo, Long> {
}
