package com.springbootproject.repository;

import com.springbootproject.entities.ToDo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long>{

    List<ToDo> findAllDone();
    List<ToDo> findAllTodo();

}