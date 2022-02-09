package com.springbootproject.controller;

import java.util.List;

import com.springbootproject.beans.TodoBean;
import com.springbootproject.dto.CreateTaskDto;
import com.springbootproject.dto.UpdateTaskDto;
import com.springbootproject.entities.ToDo;
import com.springbootproject.service.ToDoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoServiceImpl toDoService;

    @Autowired
    private TodoBean modelMapper;

    @GetMapping("/{id}")
    public ToDo get(@PathVariable("id") Long id) {
        return toDoService.read(id);
    }

    @GetMapping("/done")
    public List<ToDo> getAllDone() {
        return toDoService.readAllDone();
    }

    @GetMapping("/undone")
    public List<ToDo> getAllTodo() {
        return toDoService.readAllTodo();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        toDoService.delete(id);
    }

    @PostMapping
    public ToDo create(@Valid @RequestBody CreateTaskDto todo) {
        return toDoService.create(todo);
    }

    @PutMapping
    public ToDo update(@RequestBody UpdateTaskDto newTodo) { //Holt den Wert aus RequestBody (Was man in zb. postman sieht unter Body)

        return toDoService.update(newTodo);
    }

    @GetMapping("/done/count")
    public Long countDone() {

        return toDoService.countDone();
    }

    @GetMapping("/undone/count")
    public Long countTodo() {

        return toDoService.countTodo();
    }

    public ToDoController() {

    }
}
