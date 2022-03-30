package com.springbootproject.service;

import com.springbootproject.entities.ImageEntity;
import com.springbootproject.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

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
    public ImageEntity createImage(ImageEntity image) {
        return this.imageRepository.save(image);
    }

    @Override
    public ImageEntity updateTodo(ImageEntity image) {
        return this.imageRepository.save(image);
    }

    @Override
    public void deleteImage(Long id) {
        this.imageRepository.deleteById(id);
    }

    @Override
    public ImageEntity getImage(Long id) {
        return this.imageRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(messageSource.getMessage("notFoundError", null, LocaleContextHolder.getLocale())));
    }
}
