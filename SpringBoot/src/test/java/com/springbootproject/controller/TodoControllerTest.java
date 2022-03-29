package com.springbootproject.controller;

import com.google.gson.Gson;
import com.springbootproject.dto.TodoCreationRequest;
import com.springbootproject.entities.Todo;
import com.springbootproject.service.TodoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TodoController.class)
//@ExtendWith(MockitoExtension.class)
class TodoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TodoService todoService;

    private Todo t, t1, t2, t3;
    private TodoCreationRequest todoCreationRequest;
    private Iterable<Todo> todos, todosOpen, todosDone;
    private String JsonCreationRequest;

    @BeforeEach
    public void setUp() {
        t = new Todo("Eine Aufgabe", false);
        t1 = new Todo("Zweite Aufgabe", true);
        t2 = new Todo("Dritte Aufgabe", false);
        t3 = new Todo("Vierte Aufgabe", true);
        todos = List.of(t, t1, t2, t3);
        todosOpen = List.of(t, t2);
        todosDone = List.of(t1, t3);

        todoCreationRequest = new TodoCreationRequest();
        todoCreationRequest.setDescription("Eine Aufgabe");
        todoCreationRequest.setDone(false);

        Gson gson = new Gson();
        JsonCreationRequest = gson.toJson(todoCreationRequest);
    }

    @Test
    void getTodos() {
    }

    @Test
    void getTodo() throws Exception{
        when(todoService.getTodo(1L)).thenReturn(t1);

        mockMvc.perform(MockMvcRequestBuilders.get("/todo/1"));
    }

    @Test
    void createTodo() throws Exception {
        when(todoService.createTodo(any())).thenReturn(t1);

        mockMvc.perform(MockMvcRequestBuilders.post("/todo")
                        .content(JsonCreationRequest)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated());
                      //.andExpect(t1);
    }

    @Test
    void updateTodo() {
    }

    @Test
    void deleteTodo() {
    }
}