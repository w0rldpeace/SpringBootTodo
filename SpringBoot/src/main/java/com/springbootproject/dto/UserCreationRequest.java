package com.springbootproject.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserCreationRequest {

    @NotBlank
    private String username;
    @NotNull
    private String password;
    @NotNull
    private Long id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
