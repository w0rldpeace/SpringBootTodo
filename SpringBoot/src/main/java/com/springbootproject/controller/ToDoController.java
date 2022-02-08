package com.springbootproject.controller;

import java.util.List;

import com.springbootproject.entities.ToDo;
import com.springbootproject.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    private ToDoRepository toDoRepository;

    @GetMapping
    public List<ToDo> test(){

        return (List<ToDo>) toDoRepository.findAll();
    }

    public ToDo create(String task, Boolean state){

        ToDo t = new ToDo(task, state);

        return t;
    }

    public ToDo update(ToDo newValue){
        
        return newValue;
    }

    public void delete(){
        
    }

    public void deleteAll(List<ToDo> list){
        
    }

    // public List<ToDo> readAll(){

    // }

    public void showDone(){

    }

    public void showTodo(){

    }

    // public int countDone(){

    // }

    // public int countTodo(){

    // }
    
    public ToDoController(){

    }
}
