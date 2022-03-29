package com.springbootproject.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ImageCreationRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String extension;
    @NotNull
    private byte[] image;

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
}
