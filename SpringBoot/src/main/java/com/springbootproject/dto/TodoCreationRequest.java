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

    public Boolean getDone(){
        return done;
    }

    public void setDone(Boolean done){
        this.done = done;
    }

}
