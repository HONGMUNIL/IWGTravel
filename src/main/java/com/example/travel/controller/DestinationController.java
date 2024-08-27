package com.example.travel.controller;

import com.example.travel.entity.Destination;
import com.example.travel.service.CategoryService;
import com.example.travel.service.DestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;

@Controller
public class DestinationController {

    @Autowired
    private DestinationService destinationService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/search")
    public String searchDestinations(@RequestParam("keyword") String keyword, Model model) {
        List<Destination> searchResults = destinationService.searchDestinations(keyword);
        model.addAttribute("listDestinations", searchResults);
        return "index";
    }    
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
    @GetMapping("/category/{id}")
    public String getDestinationsByCategory(@PathVariable("id") Long categoryId, Model model) {
        List<Destination> destinations = destinationService.getDestinationsByCategory(categoryId);
        model.addAttribute("listDestinations", destinations);
        return "index";
    }
}
