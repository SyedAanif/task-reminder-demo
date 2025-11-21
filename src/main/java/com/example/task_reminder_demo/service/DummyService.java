package com.example.task_reminder_demo.service;

import com.example.task_reminder_demo.annotations.LogExecutionTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DummyService {

    @LogExecutionTime
    public String dummyMethod(int id){
        // start timer
        if (id != 1){
            throw new IllegalArgumentException("The argument can't be used");
        }

        System.out.println("Inside Dummy Method Call");
        return "Returning: "+ id;
        // end timer
        // end - start
    }
}
