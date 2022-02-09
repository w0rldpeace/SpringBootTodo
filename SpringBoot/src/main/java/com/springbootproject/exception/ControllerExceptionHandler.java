package com.springbootproject.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@RestControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {EntityNotFoundException.class}) //EntityNotFound
    public ResponseEntity<Object> resourceNotFoundException(EntityNotFoundException ex, WebRequest request){
        System.out.println(ex.getMessage());
        return handleExceptionInternal(ex, "Diese gibts nicht", new HttpHeaders(), HttpStatus.NOT_FOUND, request);
    }
}
