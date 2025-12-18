package com.example.task_reminder_demo.threading;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;
import java.util.concurrent.*;

// Thread th = new Thread(R);
//th.start();
public class ExecutorLearning {
    private static final Logger log = LoggerFactory.getLogger(ExecutorLearning.class);

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
//        Thread[] threads = new Thread[10];
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//            threads[finalI] = new Thread(() -> {
//                int res = someTask();
//                log.info("Job: {}, returned: {}", finalI, res);
//            });
////            Thread th = new Thread(() -> {
////                int res = someTask();
////                log.info("Job: {}, returned: {}", finalI, res);
////            });
////            th.start();
//            threads[i].start();
////            int res = someTask();
////            log.info("Job: {}, returned: {}", i, res);
//        }
        // CountDownLatch
        // CyclicBarrier
//       for (Thread thread : threads) {
//           try {
//               thread.join();
//           } catch (InterruptedException e) {
//               throw new RuntimeException(e);
//           }
//       }

       // Framework
        // Executor Framework Java 1.5
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        // pool of 10 threads
//        for (int i = 0; i < 10; i++) {
//            int finalI = i;
//        Future<?> future = executorService.submit(() -> {
//            int res = someTask();
//            log.info("Job: {}, returned: {}", 1, res);
//        });
////        }
//        // pool of threads
//        // submitter -> task submitted into a queue
//        executorService.shutdown();
//        future.get(); // blocking
        // Fork Join Pool task fork into small tasks wait all tasks to join back
        Future<String> fCall = executorService.submit(() -> {
            int res = someTask();
            log.info("Job: {}, returned: {}", 1, res);
            return "success";
        });

//        executorService.awaitTermination()
        log.info(fCall.get());
        log.info("Elapsed Time: {}", (System.currentTimeMillis() - start));

        // CompletableFuture Java 1.8
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> 10)
                .thenApply(i -> 2 * i) // exec1
                .thenApply(i -> i + 100); // exec2


        CompletableFuture<Integer> exceptionally = completableFuture.thenApply(integer -> integer / 0)
                .exceptionally(throwable ->{
                    log.error("Exception");
                    return 0;
                }
                );
//
        //ecommerce platform
        // book
        // check
        // place
        // payment
        // mail
        // failure

//        book
        // check
        // place
        // payment
        // mail
        // failure
        completableFuture.thenAccept(System.out::println);

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
