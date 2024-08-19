package com.example.travel.service;

import com.example.travel.model.Destination;
import com.example.travel.repository.DestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> getAllDestinations() {
        return destinationRepository.findAll();
    }

    public void addDestination(Destination destination) {
        destinationRepository.save(destination);
    }
}
