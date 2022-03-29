package com.springbootproject.controller;

import com.springbootproject.dto.ImageCreationRequest;
import com.springbootproject.dto.TodoCreationRequest;
import com.springbootproject.dto.TodoUpdateRequest;
import com.springbootproject.entities.ImageEntity;
import com.springbootproject.entities.Todo;
import com.springbootproject.service.ImageService;
import com.springbootproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService){
        this.imageService = imageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageEntity> getImage(@PathVariable("id") Long id){
        ImageEntity imageEntity = imageService.getImage(id);

        return ResponseEntity.ok(imageEntity);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createImage(@Valid @RequestBody ImageCreationRequest imageCreationRequest){
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setImage(imageCreationRequest.getImage());

        ImageEntity createdImage = this.imageService.createImage(imageEntity);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdImage.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteImage(@PathVariable("id") Long id){
        this.imageService.deleteImage(id);
        return ResponseEntity.ok().build();
    }
}
