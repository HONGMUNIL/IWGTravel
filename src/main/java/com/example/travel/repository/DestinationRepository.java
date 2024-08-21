package com.example.travel.repository;

import com.example.travel.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface DestinationRepository extends JpaRepository<Destination, Long> {
    List<Destination> findByNameContaining(String keyword);
    List<Destination> findByLocationContaining(String keyword);
}
