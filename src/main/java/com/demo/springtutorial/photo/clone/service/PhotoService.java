package com.demo.springtutorial.photo.clone.service;

import com.demo.springtutorial.photo.clone.model.Photo;
import com.demo.springtutorial.photo.clone.repository.PhotoRepository;
import org.springframework.stereotype.Service;

//@Component
@Service
public class PhotoService {
    private final PhotoRepository photoRepository;

    public PhotoService(PhotoRepository photoRepository) {
        this.photoRepository = photoRepository;
    }

    public Iterable<Photo> get() {
        return photoRepository.findAll();
    }

    public Photo get(Integer id) {
        return photoRepository.findById(id).orElse(null);
    }

    public void remove(Integer id) {
        photoRepository.deleteById(id);
    }

    public Photo save(String fileName, String contentType, byte[] data) {
        Photo photo = new Photo();
        photo.setContentType(contentType);
        photo.setFileName(fileName);
        photo.setData(data);
        return photoRepository.save(photo);
    }
}
