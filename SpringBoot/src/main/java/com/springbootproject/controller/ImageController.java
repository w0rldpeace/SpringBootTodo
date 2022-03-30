package com.springbootproject.controller;

import com.springbootproject.entities.ImageEntity;
import com.springbootproject.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.io.IOException;
import java.net.URI;

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

    @GetMapping("/{id}/visible")
    public ResponseEntity<byte[]> getVisibleImage(@PathVariable("id") Long id){
        ImageEntity imageEntity = imageService.getImage(id);

        return ResponseEntity.ok().contentType(MediaType.valueOf(imageEntity.getExtension())).body(imageEntity.getImage());
    }

    @PostMapping
    public ResponseEntity<?> createImage(@Valid @RequestParam("image") MultipartFile imageFile) throws IOException {
        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setExtension(imageFile.getContentType());
        imageEntity.setName(imageFile.getOriginalFilename());
        imageEntity.setImage(imageFile.getBytes());

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
