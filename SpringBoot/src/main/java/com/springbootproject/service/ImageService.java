package com.springbootproject.service;

import com.springbootproject.entities.ImageEntity;
import com.springbootproject.entities.Todo;

public interface ImageService {

    ImageEntity createImage(ImageEntity image);
    ImageEntity updateTodo(ImageEntity image);
    void deleteImage(Long id);
    ImageEntity getImage(Long id);

}
