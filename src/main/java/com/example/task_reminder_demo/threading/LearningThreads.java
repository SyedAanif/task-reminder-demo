package com.example.task_reminder_demo.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LearningThreads {
    private static final Logger log = LoggerFactory.getLogger(LearningThreads.class);

    public static void main(String[] args) throws InterruptedException {
        log.info("Multi-Threading Before");

//        // Using extend Thread
//        MyThread th = new MyThread("my-thread");
////        th.setDaemon(true);
//        th.start();

        // Using implement Runnable interface
//        Runnable r = new RunnableThread();
//        Thread th = new Thread(r);
//        th.start();

        // Anonymous
//        Runnable runnable = new Runnable() {
//            @Override
//            public void run() {
//                log.info("Anonymous Runnable");
//            }
//        };
//
//        Thread th = new Thread(runnable);
//        th.start();

//        // Inline
//        Thread th = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                log.info("Inline Runnable");
//            }
//        });
//        th.start();

//        Imperative Programming
//        Java > 1.7; Declarative Approach -> Functional Programming; Lambdas... Functional Interfaces
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                log.info("Lambda Runnable");
//            }
//        };
        // ES6, CJS
//        Thread th = new Thread(() -> log.info("Lambda Runnable"));
//        th.start();

        // States of Thread
        Thread th = new Thread(() -> {
            log.info("Inside runnable");
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
        });
//        log.info(String.valueOf(th.getState())); // NEW
//        th.start();
//        log.info(String.valueOf(th.getState())); // RUNNABLE
//        Thread.sleep(100);
////        log.info(String.valueOf(th.getState())); // TIMED_WAITING
//        th.join();
//        log.info(String.valueOf(th.getState())); // TERMINATED

        // Priority
//        log.info(String.valueOf(Thread.currentThread().getPriority()));
//        Thread low = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("Low Priority");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            String st = "dum";
//            for (int i = 0; i < 1000000000; i++) {
//                st += st;
//            }
//        });
//
//        Thread high = new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                System.out.println("High Priority");
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            String st = "dum";
//            for (int i = 0; i < 1000000000; i++) {
//                st += st;
//            }
//        });
//        low.setPriority(1);
//        high.setPriority(10);

//        low.start();
//        high.start();


        // SYNCHRONISATION
        Incrementor inc = new Incrementor();

       SynchronisationThread t1 = new SynchronisationThread(inc);
       SynchronisationThread t2 = new SynchronisationThread(inc);

       t1.start();
       t2.start();

       t1.join();
       t2.join();

        System.out.println(inc.getCount());


        log.info("Multi-Threading After");
//        System.out.println(Thread.currentThread().getName());
    }
}
