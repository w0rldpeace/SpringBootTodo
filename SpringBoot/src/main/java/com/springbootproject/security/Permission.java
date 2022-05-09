package com.springbootproject.security;

public enum Permission {

    TODO_READ("todo:read"),
    TODO_WRITE("todo:write"),
    TODO_DELETE("todo:delete"),
    USERS_READ("users:read"),
    USERS_UPDATE("users:update"),
    USERS_DELETE("users:delete"),
    USERS_WRITE("users:write");

    private final String permission;

    Permission(String permission) { this.permission = permission; }

    public String getPermission() { return permission; }

}
