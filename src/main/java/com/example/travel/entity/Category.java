package com.example.travel.entity;

import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String name;

    @OneToMany(mappedBy = "category")
    private Set<Destination> destinations;

    // Getters and Setters
}
