package com.springbootproject.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TodoCreationRequest {

    @NotBlank
    private String description;
    @NotNull
    private Boolean done;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(boolean b) {
        this.done = b;
    }

    public Boolean getDone(){
        return done;
    }
}
