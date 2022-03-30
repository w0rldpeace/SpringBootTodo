package com.springbootproject.controller;

import com.springbootproject.entities.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stuff")
public class OpenController {

    @GetMapping
    public String getUnauthorized(){

        return "stuff";
    }
}
