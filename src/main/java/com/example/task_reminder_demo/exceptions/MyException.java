package com.example.task_reminder_demo.exceptions;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

// throwable
// error --> non-recoverable, fatal . stackoverflow, out_of_memory. System.kill
// exception -> recovery(handle)
// checked -> compiler lets know... handling of these exceptions is necessary
// unchecked -> compiler cannot catch ahead of time... handle these exceptions
@Component
// service, configuration, repository, controller
public class MyException {

    @PostConstruct
    public void learnExceptions() {
        System.out.println("handle exceptions");
//        List<byte[]> list = new ArrayList<>();
//        while (true) { // OutOfMemoryError
////            System.out.println("Here");
//            list.add(new byte[10*1024*1024]);
//        }
//        learnExceptions(); // StackOverflowError

        // checkedExceptions
//        IOException, InterruptedException
//        try{
//            Thread.sleep(12*100L);
////            new FileReader()
//        } catch (InterruptedException e) {
//            // swallowing
////            print
////            throw e;
////            throw new RuntimeException("");
//        } catch (Exception e) {
//
//        } finally {
//    }
//        try(new File)
        // try-with-resources

        // unchecked Exceptions
        // arithemticException
//        int a = 10 / 0;

        // try-catch
        // throws
//        throw new CustomException("my message");
    }
}

