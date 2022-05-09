package com.springbootproject.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TodoUpdateRequest {

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NotBlank
    private String description;
    @NotNull
    private Long id;
    @NotNull
    private Boolean done;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
