package com.springbootproject.controller;

import java.util.List;

import com.springbootproject.entities.ToDo;

public class ToDoController {
    
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
