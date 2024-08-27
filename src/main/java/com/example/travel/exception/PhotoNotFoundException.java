package com.example.travel.exception;

public class PhotoNotFoundException extends RuntimeException {

    public PhotoNotFoundException(Long id) {
        super("Photo not found with id: " + id);
    }
}
