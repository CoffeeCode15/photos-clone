package com.demo.springtutorial.photo.clone.repository;

import com.demo.springtutorial.photo.clone.model.Photo;
import org.springframework.data.repository.CrudRepository;

public interface PhotoRepository extends CrudRepository<Photo, Integer> {
}
