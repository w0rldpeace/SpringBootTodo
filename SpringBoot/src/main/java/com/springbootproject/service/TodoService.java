package com.springbootproject.service;

import com.springbootproject.entities.Todo;

import java.util.List;

public interface TodoService {

    Todo createTodo(Todo todo);
    Todo updateTodo(Todo todo);
    void deleteTodo(Long todoId);
    Todo getTodo(Long todoId);
    List<Todo> getTodos();
    List<Todo> getDoneTodos();
    List<Todo> getOpenTodos();

}
