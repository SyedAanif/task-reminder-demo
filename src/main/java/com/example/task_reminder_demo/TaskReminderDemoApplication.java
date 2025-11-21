package com.example.task_reminder_demo;

import com.example.task_reminder_demo.controller.StudentController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.GetMapping;


// JAVA
@SpringBootApplication
@EnableScheduling
@EnableAspectJAutoProxy
// EventHandling
// Event
// Object
// Handler
// JFR Java Flight Recorders --> Profiling --> JMX
public class TaskReminderDemoApplication implements ApplicationListener<ApplicationReadyEvent> {

	public static void main(String[] args) {
        //
         //
		SpringApplication.run(TaskReminderDemoApplication.class, args);
        System.out.println("I am here!!!");
        ///
        ///
        ///
        // api, business, persistence
        // config, security, utils
	}

    // cdc
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        // health check code
        // Queues
        // health-checks
        System.out.println("Application is ready !!!!!");
        // one thread
        // consumer producer join notify
        // events
    }

    // Health-Indicator

//    @EventListener(ApplicationReadyEvent.class)
//    public void onStartup() {
//        System.out.println(" I started!!!!!!!");
//    }

}

// Version Control
// git
// Remote
// Repo: GitHub, GitLab, BitBucket, Azure DevOps(ADO), SVN, Code Commit AWS

// First
// local --> PUSH to remote
// Create it on remote --> PULL/CLONE it to local

// push to remote

// local(working area) --> ADD --> STAGING AREA --> COMMIT  --> PUSH to REMOTE
// FETCH + MERGE =  PULL

// MARKDOWNS , .md
//


