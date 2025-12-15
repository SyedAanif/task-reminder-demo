package com.example.task_reminder_demo.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

// Preemption
// only one thread can access the resource
// hold and wait indefinitely, without preemption
// circular dependant

// wait()
// notify()
// notifyAll()
// Consumer-Producer
// producer buffer consumer
public class Deadlock {
    public static void main(String[] args) {
        // Deadlock
        // A B
        // B A

        A a = new A();
        B b = new B();

        Thread t1 = new Thread(new Task1(a, b), "A Thread");
        Thread t2 = new Thread(new Task2(a, b), "B Thread");

        t1.start();
        t2.start();
    }
}

class A {
    private static final Logger log = LoggerFactory.getLogger(A.class);

    public synchronized void aUsesB(B b) {
        log.info(String.format("This: %s is accessing passed: %s", this, b));
        b.finishSomeTask();
    }

    public synchronized void finishSomeTask() {
        log.info(String.format("Finished Task: %s", this));
    }
}

class B {
    private static final Logger log = LoggerFactory.getLogger(B.class);

    public synchronized void bUsesA(A a) {
        log.info(String.format("This: %s is accessing passed: %s", this, a));
        a.finishSomeTask();
    }

    public synchronized void finishSomeTask() {
        log.info(String.format("Finished Task: %s", this));
    }
}

class Task1 implements Runnable{
    private A a;
    private B b;

    public Task1(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        a.aUsesB(b);
    }
}

class Task2 implements Runnable{
    private A a;
    private B b;

    public Task2(A a, B b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (a) { // if you comment this synchronisation, deadlock happens
            b.bUsesA(a);
        }

    }
}
