package com.springbootproject.security;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static com.springbootproject.security.Permission.*;

public enum Role {

    USER(Set.of(TODO_READ, TODO_WRITE, TODO_DELETE)),
    ADMIN(Set.of(TODO_READ, TODO_WRITE, TODO_DELETE,
            USERS_READ, USERS_WRITE, USERS_DELETE)),
    ANALYST(Set.of(TODO_READ, TODO_WRITE, USERS_READ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority("ROLE_" + permission.getPermission()))
                .collect(Collectors.toSet());
    }

    private Set<Permission> getPermissions() {
        return permissions;
    }
}
