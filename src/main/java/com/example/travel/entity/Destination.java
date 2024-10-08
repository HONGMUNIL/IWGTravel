package com.example.travel.entity
;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String name;
    public String description;
    public String location;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    
    public Destination() {
    }

    public Destination(String name, String description, String location) {
        this.name = name;
        this.description = description;
        this.location = location;
    }
     // Getters and Setters
     public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // Getters and Setters
}
