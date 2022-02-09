package com.springbootproject.dto;

import javax.validation.constraints.NotBlank;

public class CreateTaskDto {
    @NotBlank
    private String task;

    public String getTask() {

        return task;
    }

    public void setTask(String task) {

        this.task = task;
    }

}
