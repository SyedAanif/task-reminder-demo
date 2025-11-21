package com.example.task_reminder_demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

@Configuration
public class ScheduledConfig {

    // System.getProperty().asString

    @Value(value = "${customName:defaultValue}") // SpEL
    private String name;

    @Bean
    public ScheduledExecutorService scheduledExecutorService() {
        System.out.println("######################### Name: "+name);
        return Executors.newScheduledThreadPool(2);
        // IO --> Core-processors
        // worker threads --> 2 8 io
    }
}
