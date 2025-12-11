package com.example.task_reminder_demo.threading;

import java.util.concurrent.locks.ReentrantLock;

public class Incrementor {

    private int count = 0;

//    public synchronized void increment() {
    public void increment() {
        synchronized (this) {
            count++;
        }
    }

    public int getCount() {
        return count;
    }

    // Singleton Pattern
    // Double Locking

    // Lock
    // Implicit Lock
    // Explicit Lock -> Reentrant Lock; lock.lock(); lock.unlock()

    // Mutex-> Mutual Exclusion
    // Write
    //lock
    // write my job
    // unlock

    // Read

}
