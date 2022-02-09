package com.springbootproject.service;

import com.springbootproject.dto.CreateTaskDto;
import com.springbootproject.dto.UpdateTaskDto;
import com.springbootproject.entities.ToDo;
import org.hibernate.sql.Update;

import java.util.List;

public interface ToDoService {


    ToDo create(CreateTaskDto todo);
    ToDo read(Long id);
    ToDo update(UpdateTaskDto newTask);
    void delete(Long id);
    void deleteAll();
    List<ToDo> readAllDone();
    List<ToDo> readAllTodo();
    Long countDone();
    Long countTodo();

}
