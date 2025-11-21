package com.example.task_reminder_demo.models;

import lombok.Data;

//@Data
public class StudentDto {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
