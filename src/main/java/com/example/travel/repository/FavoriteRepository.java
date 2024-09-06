package com.example.travel.repository;

import com.example.travel.model.Favorite;
import com.example.travel.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite, Long> {
    List<Favorite> findByUser(User user);
}
