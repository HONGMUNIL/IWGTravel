package com.example.travel.controller;

import com.example.travel.entity.User;
import com.example.travel.entity.Destination;
import com.example.travel.service.FavoriteService;
import com.example.travel.service.DestinationService;
import com.example.travel.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@Controller
@RequestMapping("/favorites")
public class FavoriteController {

    private final FavoriteService favoriteService;
    private final UserService userService;
    private final TravelDestinationService travelDestinationService;

    public FavoriteController(FavoriteService favoriteService, UserService userService, TravelDestinationService travelDestinationService) {
        this.favoriteService = favoriteService;
        this.userService = userService;
        this.travelDestinationService = travelDestinationService;
    }

    @GetMapping
    public String viewFavorites(Principal principal, Model model) {
        User user = userService.findByUsername(principal.getName());
        model.addAttribute("favorites", favoriteService.getUserFavorites(user));
        return "favorites";
    }

    @PostMapping("/add")
    public String addFavorite(@RequestParam Long destinationId, Principal principal) {
        User user = userService.findByUsername(principal.getName());
        TravelDestination destination = travelDestinationService.getDestinationById(destinationId);
        favoriteService.addFavorite(user, destination);
        return "redirect:/favorites";
    }

    @PostMapping("/remove")
    public String removeFavorite(@RequestParam Long favoriteId) {
        favoriteService.removeFavorite(favoriteId);
        return "redirect:/favorites";
    }
}
