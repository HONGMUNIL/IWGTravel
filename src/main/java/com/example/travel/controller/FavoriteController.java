package com.example.travel.controller;

import com.example.travel.model.User;
import com.example.travel.model.TravelDestination;
import com.example.travel.service.FavoriteService;
import com.example.travel.service.TravelDestinationService;
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

 
}
