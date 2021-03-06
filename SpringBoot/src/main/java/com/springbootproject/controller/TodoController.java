package com.springbootproject.controller;

import java.net.URI;
import java.util.List;

import com.springbootproject.dto.TodoCreationRequest;
import com.springbootproject.dto.TodoUpdateRequest;
import com.springbootproject.entities.Todo;
import com.springbootproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    @PreAuthorize("hasRole('todo:read')")
    public ResponseEntity<List<Todo>> getTodos(){
        List<Todo> todos = this.todoService.getTodos();

        return ResponseEntity.ok(todos);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('todo:read')")
    public ResponseEntity<Todo> getTodo(@PathVariable("id") Long id){
        Todo todo = todoService.getTodo(id);

        return ResponseEntity.ok(todo);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('todo:write')")
    public ResponseEntity<?> createTodo(@Valid @RequestBody TodoCreationRequest todoCreationRequest){
        Todo todo = new Todo();
        todo.setDescription(todoCreationRequest.getDescription());

        Todo createdTodo = this.todoService.createTodo(todo);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(createdTodo.getId()).toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @PreAuthorize("hasRole('todo:write')")
    public ResponseEntity<?> updateTodo(@Valid @RequestBody TodoUpdateRequest todoUpdateRequest){
        Todo todo = todoService.getTodo(todoUpdateRequest.getId());
        todo.setDescription(todoUpdateRequest.getDescription());
        todo.setDone(todoUpdateRequest.getDone());

        return ResponseEntity.ok(this.todoService.updateTodo(todo));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('todo:delete')")
    public ResponseEntity<?> deleteTodo(@PathVariable("id") Long id){
        this.todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }
}
