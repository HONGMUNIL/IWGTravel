package com.example.travelapp.controller;

import com.example.travelapp.model.Photo;
import com.example.travelapp.service.PhotoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/gallery")
public class GalleryController {

    private final PhotoService photoService;

    public GalleryController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping
    public String viewGallery(Model model) {
        model.addAttribute("photos", photoService.getAllPhotos());
        return "gallery";
    }

    @PostMapping("/upload")
    public String uploadPhoto(@RequestParam("title") String title,
                              @RequestParam("description") String description,
                              @RequestParam("file") MultipartFile file,
                              Model model) {
        try {
            photoService.uploadPhoto(title, description, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/gallery";
    }
}
