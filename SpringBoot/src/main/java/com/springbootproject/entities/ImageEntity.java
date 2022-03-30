package com.springbootproject.entities;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="IMAGES")
public class ImageEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @Column(name="filename", length=100, nullable=false, unique=true)
    private String name;
    @Column(name="extension", length=10, nullable=false, unique=false)
    private String extension;
    @Column(name="image", length=6666666, nullable = false)
    private byte[] image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public ImageEntity() {

    }

    public ImageEntity(String name, String extension, byte[] image) {
        this.name = name;
        this.extension = extension;
        this.image = image;
    }
}
