package com.demo.springtutorial.photo.clone.web;

import com.demo.springtutorial.photo.clone.model.Photo;
import com.demo.springtutorial.photo.clone.service.PhotoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;

@RestController
public class PhotoController {
    private final PhotoService photoService;

    public PhotoController(PhotoService photoService) {
        this.photoService = photoService;
    }

    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    @GetMapping("/photos")
    public Iterable<Photo> get() {
        return photoService.get();
    }

    @GetMapping("/photos/{id}")
    public Photo get(@PathVariable Integer id) {
        Photo photo = photoService.get(id);
        if (photo == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return photoService.get(id);
    }

    @DeleteMapping("/photos/{id}")
    public void delete(@PathVariable Integer id) {
        photoService.remove(id);
    }

    @PostMapping("/photos")
    public Photo create(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.save(file.getOriginalFilename(), file.getContentType(), file.getBytes());
    }
}
