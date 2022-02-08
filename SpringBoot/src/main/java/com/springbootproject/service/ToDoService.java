package com.springbootproject.service;

import com.springbootproject.entities.ToDo;

import java.util.List;

public interface ToDoService {


    ToDo create(ToDo todo);
    ToDo read(Long id);
    ToDo update(ToDo newTask);
    void delete(Long id);
    void deleteAll();
    List<ToDo> readAllDone();
    List<ToDo> readAllTodo();
    Long countDone();
    Long countTodo();

}
