package com.example.task_reminder_demo.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RunnableThread implements Runnable{
    private static final Logger log = LoggerFactory.getLogger(RunnableThread.class);

    @Override
    public void run() {
        log.info("Inside Runnable");
    }
}
