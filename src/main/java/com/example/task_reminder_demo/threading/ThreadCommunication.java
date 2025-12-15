package com.example.task_reminder_demo.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// Consumer-Producer Problem
// Producer -- Buffer -- Consumer
public class ThreadCommunication {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Thread prd = new Thread(new Producer(buffer), "Producer-Thread");
        Thread cons = new Thread(new _Consumer(buffer), "Consumer-Thread");

        prd.start();
        cons.start();
    }
}

class Buffer {
    private static final Logger log = LoggerFactory.getLogger(Buffer.class);

    private int data;
    private boolean hasData;

    public synchronized void produce(int i) {
        while (hasData) {
            try{
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        data = i;
        hasData = true;
        log.info("Produced: {}", data);
        notify();
    }

    public synchronized void consume() {
        while (!hasData) {
            try{
                wait();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        log.info("Consumed: {}", data);
        hasData = false;
        notify();
    }
}

class Producer implements Runnable {
    private Buffer buffer;

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.produce(i);
        }
    }
}

class _Consumer implements Runnable {
    private Buffer buffer;

    public _Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            buffer.consume();
        }
    }
}

