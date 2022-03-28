package com.springbootproject.dto;

import javax.validation.constraints.NotBlank;

public class TodoCreationRequest {

    @NotBlank
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
