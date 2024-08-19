package com.example.travel.controller;

import com.example.travel.model.Destination;
import com.example.travel.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listDestinations", destinationService.getAllDestinations());
        return "index";
    }

    @GetMapping("/showNewDestinationForm")
    public String showNewDestinationForm(Model model) {
        Destination destination = new Destination();
        model.addAttribute("destination", destination);
        return "new_destination";
    }

    @PostMapping("/saveDestination")
    public String saveDestination(Destination destination) {
        destinationService.addDestination(destination);
        return "redirect:/";
    }
}
