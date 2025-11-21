package com.example.task_reminder_demo.service;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class ReminderService {
    // script at 12 am -> CRON Job
    // at 12 am everyday

    // Scheduling
    // in plain JAVA or low-level API -> ScheduledExecutorService -> java.util.concurrent
    // @Scheduled

    // jobs
    // check my phone contacts
    // check their birthdays in google contacts
    // send them a custom message

    // @Primary
    // Qualifier
    private static final Logger log = LoggerFactory.getLogger(ReminderService.class);
    // schedule
    // ScheduledExecutorService
    // annotation -> Scheduled

//    private ScheduledExecutorService ses;
//
////    @Autowired
//    public ReminderService(ScheduledExecutorService ses) {
//        this.ses = ses;
//    }
//
//    @PostConstruct
//    public void scheduling(){
//        this.ses.scheduleAtFixedRate(() -> log.info("Running some task"), 2, 5000, TimeUnit.MILLISECONDS);
//    }
    // JDBC JPA

    // fixedRate, fixedRateString
    // fixedDelay, fixedDelayString
    // string version
    // initialDelay
    // CRON -> * * * * * *
//    @Scheduled(fixedRate = 5000)
//    @Scheduled(fixedRateString = "${ses.rate:2000}") // SpEL
    public void schedulingFixedRate() {
        log.info("******* FIXED RATE START *******");

//        simulateWait(12);
//
//        log.info("******* FIXED RATE END *******");
    }

    private void simulateWait(int wait) {
        log.info("Running some task!!!*********");
        try {
            Thread.sleep(wait * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
//
//    @Scheduled(fixedRate = 5000)
//    public void schedulingDelayRate() {
//        log.info("Running some task!!!*********");
//    }
    // t1 5s t2
    // t1 12s+5s 17s

    // 5s

    // Fixed Rate
    // t1 ---------------------
    // t1+5s

    // Fixed Delay
    // t1 --------------------------- t2+5s -----------------
}
