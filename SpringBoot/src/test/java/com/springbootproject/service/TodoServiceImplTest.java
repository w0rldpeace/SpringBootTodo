package com.springbootproject.service;

import com.springbootproject.repository.TodoRepository;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.context.MessageSourceAutoConfiguration;
import org.springframework.context.MessageSource;

import javax.persistence.EntityNotFoundException;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ImportAutoConfiguration(MessageSourceAutoConfiguration.class)
class TodoServiceImplTest {

    @Mock
    private TodoRepository todoRepository;
    @InjectMocks //Alle mocks die hier erstellt wurden,werden automatisch mit gemappt.s
    private TodoServiceImpl todoService;

    @Test
    void createTodo() {
    }

    @Test
    void updateTodo() {
    }

    @Test
    void deleteTodo() {
    }

    @Test
    void getInvalidTodo(){
        assertThrows(EntityNotFoundException.class, () -> todoService.getTodo(69L));
    }
    @Test
    void getTodo() {
    }

    @Test
    void getTodos() {
    }

    @Test
    void getDoneTodos() {
    }

    @Test
    void getOpenTodos() {
    }
}