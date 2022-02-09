package com.springbootproject.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateTaskDto {

    @NotBlank
    private String task;
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
