package com.example.task_reminder_demo.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

// Thread th = new Thread(R);
//th.start();
public class ThreadPooling {
    private static final Logger log = LoggerFactory.getLogger(ThreadPooling.class);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            threads[finalI] = new Thread(() -> {
                int res = someTask();
                log.info("Job: {}, returned: {}", finalI, res);
            });
//            Thread th = new Thread(() -> {
//                int res = someTask();
//                log.info("Job: {}, returned: {}", finalI, res);
//            });
//            th.start();
            threads[i].start();
//            int res = someTask();
//            log.info("Job: {}, returned: {}", i, res);
        }
       for (Thread thread : threads) {
           try {
               thread.join();
           } catch (InterruptedException e) {
               throw new RuntimeException(e);
           }
       }

       // Framework
        // Executor Framework Java 1.5
        log.info("Elapsed Time: {}", (System.currentTimeMillis() - start));
    }

    private static int someTask() {
        try {
            Thread.sleep(1000); // simulation of some time taken
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new Random().nextInt();
    }
}
