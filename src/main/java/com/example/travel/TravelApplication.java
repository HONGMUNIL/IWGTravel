package com.example.travel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@SpringBootApplication
public class TravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(TravelApplication.class, args);
	}
	@Autowired
    private DestinationRepository destinationRepository;

    public List<Destination> searchDestinations(String keyword) {
        return destinationRepository.findByNameContaining(keyword);
    }

}
