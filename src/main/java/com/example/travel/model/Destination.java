package com.example.travel.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    public String name;
    public String description;
    public String location;

    public Destination() {
    }

    public Destination(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }

    // Getters and Setters
}
