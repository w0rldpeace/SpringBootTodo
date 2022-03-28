package com.springbootproject.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class TodoUpdateRequest {

    @NotBlank
    private String task;

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

    public String getTask() {

        return task;
    }

    public void setTask(String task) {

        this.task = task;
    }

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
