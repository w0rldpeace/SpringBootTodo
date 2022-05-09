package com.springbootproject.security;

public enum Permission {

    TODO_READ("todo:read"),
    TODO_WRITE("todo:write"),
    USERS_READ("users:read"),
    USERS_WRITE("users:write");

    private final String permission;

    Permission(String permission) { this.permission = permission; }

    public String getPermission() { return permission; }

}
