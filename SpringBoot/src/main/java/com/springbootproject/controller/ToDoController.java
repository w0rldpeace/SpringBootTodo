package com.springbootproject.controller;

import java.util.List;

import com.springbootproject.entities.ToDo;
import com.springbootproject.repository.ToDoRepository;
import com.springbootproject.service.ToDoService;
import com.springbootproject.service.ToDoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoServiceImpl toDoService;

    @GetMapping("/{id}")
    public ToDo get(@PathVariable("id") Long id){
        return toDoService.read(id);
    }

    @GetMapping
    public List<ToDo> getAllTodo(){
        return toDoService.readAllTodo();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id){
        toDoService.delete(id);
    }

    @PostMapping // create
    public ToDo create(@RequestBody ToDo todo){
        return toDoService.create(todo);
    }

    //Frage zum Update
    @PutMapping //update
    public ToDo update(@RequestBody ToDo newTodo){
        return toDoService.update(newTodo);
    }

    public ToDoController(){

    }
}
