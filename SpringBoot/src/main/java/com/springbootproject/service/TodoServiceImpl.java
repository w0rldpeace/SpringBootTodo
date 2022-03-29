package com.springbootproject.service;

import com.springbootproject.dto.TodoCreationRequest;
import com.springbootproject.dto.TodoUpdateRequest;
import com.springbootproject.entities.Todo;
import com.springbootproject.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private final TodoRepository todoRepository;
    @Autowired
    private MessageSource messageSource;

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }

    @Override
    public Todo createTodo(Todo todo) {
        return this.todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Todo todo) {
        return this.todoRepository.save(todo);
    }

    @Override
    public void deleteTodo(Long todoId) {
        todoRepository.deleteById(todoId);
    }

    @Override
    public Todo getTodo(Long todoId) {
        return todoRepository.findById(todoId).orElseThrow(
                () -> new EntityNotFoundException(todoId.toString())
        );
    }

    @Override
    public List<Todo> getTodos() {
        return (List<Todo>) this.todoRepository.findAll();
    }

    @Override
    public List<Todo> getDoneTodos() {
        return this.todoRepository.findByDoneTrue();
    }

    @Override
    public List<Todo> getOpenTodos() {
        return this.todoRepository.findByDoneFalse();
    }
}
