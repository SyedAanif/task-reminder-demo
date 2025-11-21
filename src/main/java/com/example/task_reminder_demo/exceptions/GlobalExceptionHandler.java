package com.example.task_reminder_demo.exceptions;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// AOP
@RestControllerAdvice
@Order(1)
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseStatus
    public ResponseEntity<CustomErrorResponse> handleAnyException(CustomException e){
        System.out.println("Handling Exception");

        CustomErrorResponse errorResponse = new CustomErrorResponse(e.getMessage(), "some error code", "");

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
