package com.springbootproject.controller;

import com.springbootproject.dto.TodoCreationRequest;
import com.springbootproject.dto.TodoUpdateRequest;
import com.springbootproject.dto.UserCreationRequest;
import com.springbootproject.dto.UserUpdateRequest;
import com.springbootproject.entities.Todo;
import com.springbootproject.entities.User;
import com.springbootproject.service.TodoService;
import com.springbootproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('users:read')")
    public ResponseEntity<User>getUser(@PathVariable("id") Long id) {
        User user = userService.getUser(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    @PreAuthorize("hasRole('users:read')")
    public ResponseEntity<List<User>> getUserList(){
        List<User> users = this.userService.getUserList();

        return ResponseEntity.ok(users);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('users:write')")
    public ResponseEntity<?> createUser(@Valid @RequestBody UserCreationRequest userCreationRequest){
        User user = new User();
        user.setUsername(userCreationRequest.getUsername());
        user.setPassword(userCreationRequest.getPassword());

        User createdUser = this.userService.createUser(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @PreAuthorize("hasRole('users:write')")
    public ResponseEntity<?> updateUser(@Valid @RequestBody UserUpdateRequest userUpdateRequest){
        User user = userService.getUser(userUpdateRequest.getId());
        user.setUsername(userUpdateRequest.getUsername());
        user.setPassword(userUpdateRequest.getPassword());

        return ResponseEntity.ok(this.userService.updateUser(user));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('users:delete')")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        this.userService.deleteUser(id);
        return ResponseEntity.ok().build();
    }
}
