package com.example.task_reminder_demo.threading;

public class SynchronisationThread extends Thread{

    private Incrementor incrementor;

    public SynchronisationThread(Incrementor incrementor){
        this.incrementor = incrementor;
    }

    @Override
    public void run() {
        // job of incrementing
        for (int i = 0; i < 1000; i++) {
            incrementor.increment();
        }
    }

}
