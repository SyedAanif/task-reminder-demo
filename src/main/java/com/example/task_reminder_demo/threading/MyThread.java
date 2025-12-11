package com.example.task_reminder_demo.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyThread extends Thread {

    private static final Logger log = LoggerFactory.getLogger(MyThread.class);


    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        log.info("Inside My-Thread");
        try {
            Thread.sleep(3000);
            log.info("Finished doing some task Inside My-Thread");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
