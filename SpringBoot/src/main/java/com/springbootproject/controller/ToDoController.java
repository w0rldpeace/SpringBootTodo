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
    public ToDo create(@RequestBody ToDo todo) {
        return toDoService.create(todo);
    }

    @PutMapping
    public ToDo update(@RequestBody ToDo newTodo) { //Holt den Wert aus RequestBody (Was man in zb. postman sieht unter Body)
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
