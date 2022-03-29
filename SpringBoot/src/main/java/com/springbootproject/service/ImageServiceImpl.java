package com.springbootproject.service;

import com.springbootproject.entities.ImageEntity;
import com.springbootproject.repository.ImageRepository;
import com.springbootproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    private final ImageRepository imageRepository;
    @Autowired
    private MessageSource messageSource;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository){
        this.imageRepository = imageRepository;
    }

    @Override
    public ImageEntity createIamge(ImageEntity image) {
        return null;
    }

    @Override
    public ImageEntity updateTodo(ImageEntity image) {
        return null;
    }

    @Override
    public void deleteImage(Long id) {

    }

    @Override
    public ImageEntity getImage(Long id) {
        return null;
    }
}
