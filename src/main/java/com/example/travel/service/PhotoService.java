package com.example.travelapp.service;

import com.example.travelapp.exception.PhotoNotFoundException;
import com.example.travelapp.model.Photo;
import com.example.travelapp.repository.PhotoRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Photo uploadPhoto(String title, String description, MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        Path uploadPath = Paths.get("uploads/");

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        file.transferTo(uploadPath.resolve(fileName));

        Photo photo = new Photo();
        photo.setTitle(title);
        photo.setDescription(description);
        photo.setFileName(fileName);
        return photoRepository.save(photo);
    }

  
}
