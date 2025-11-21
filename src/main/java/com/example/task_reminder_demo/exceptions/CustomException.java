package com.example.task_reminder_demo.exceptions;

public class CustomException extends RuntimeException{

    public CustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomException(String message) {
        super(message);
    }
}
