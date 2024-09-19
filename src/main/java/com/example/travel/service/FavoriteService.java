package com.example.travel.service;

import com.example.travel.entity.Favorite;
import com.example.travel.entity.Destination;
import com.example.travel.entity.User;
import com.example.travel.repository.FavoriteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;

    public FavoriteService(FavoriteRepository favoriteRepository) {
        this.favoriteRepository = favoriteRepository;
    }

    public Favorite addFavorite(User user, Destination destination) {
        Favorite favorite = new Favorite();
        favorite.setUser(user);
        favorite.setTravelDestination(destination);
        return favoriteRepository.save(favorite);
    }

    public void removeFavorite(Long favoriteId) {
        favoriteRepository.deleteById(favoriteId);
    }

    public List<Favorite> getUserFavorites(User user) {
        return favoriteRepository.findByUser(user);
    }
}
