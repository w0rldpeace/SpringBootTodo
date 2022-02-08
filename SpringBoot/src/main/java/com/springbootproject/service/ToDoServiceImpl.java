package com.springbootproject.service;

import com.springbootproject.entities.ToDo;
import com.springbootproject.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService{

    @Autowired
    private ToDoRepository toDoRepository;

    @Override
    public ToDo create(ToDo todo) {

       return toDoRepository.save(todo);
    }

    @Override
    public ToDo read(Long id) {
        return toDoRepository.findById(id).orElse(null);
    }

    public ToDo update(ToDo newTask) {

        return toDoRepository.save(newTask);
    }

    @Override
    public void delete(Long id) {
        toDoRepository.deleteById(id);
    }

    @Override
    public void deleteAll() {
        toDoRepository.deleteAll();
    }

    @Override
    public List<ToDo> readAllDone() {

        return (List<ToDo>) toDoRepository.findAll();
    }

    @Override
    public List<ToDo> readAllTodo() {
        return (List<ToDo>) toDoRepository.findAll();
    }

    @Override
    public Long countDone() {

        return toDoRepository.count();
    }

    @Override
    public Long countTodo() {
        return toDoRepository.count();
    }
}
