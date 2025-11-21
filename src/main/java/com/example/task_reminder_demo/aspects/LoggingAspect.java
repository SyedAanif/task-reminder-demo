package com.example.task_reminder_demo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    // ADVICE
//    @Before("execution(* com.example.task_reminder_demo.service.DummyService.dummyMethod(..))")
//    public void before(JoinPoint joinPoint) {
//        System.out.println("Before: "+ joinPoint.getSignature());
//    }
//
//    @After("execution(* com.example.task_reminder_demo.service.DummyService.dummyMethod(..))")
//    public void after(JoinPoint joinPoint) {
//        System.out.println("After: "+ joinPoint.getSignature());
//    }
//
//    @AfterThrowing(pointcut = "execution(* com.example.task_reminder_demo.service.DummyService.dummyMethod(..))", throwing = "ex")
//    public void handleException(JoinPoint jp, Exception ex) {
//        System.out.println("Exception when calling: "+ jp.getSignature());
//        System.out.println("Exception: "+ ex.getMessage());
//    }

//    @Pointcut("within(com.example.task_reminder_demo.service..*)")
//    public void logPackage(){}
//    @Around("logPackage()")
//    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
//        long start = System.currentTimeMillis();
//        System.out.println("Before: "+ pjp.getSignature());
//
//        Object proceed = pjp.proceed();
//
//        System.out.println("After: "+ pjp.getSignature());
//
//        long executionTime = System.currentTimeMillis() - start;
//
//        System.out.println("Executed in: "+executionTime);
//        return proceed;
//    }


    @Around("@annotation(com.example.task_reminder_demo.annotations.LogExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Before: "+ pjp.getSignature());

        Object proceed = pjp.proceed();

        System.out.println("After: "+ pjp.getSignature());

        long executionTime = System.currentTimeMillis() - start;

        System.out.println("Executed in: "+executionTime);
        return proceed;
    }


    // around --> methodcall before and after
    // afterreturning
    // afterthrowing

    // within
    // annotation

    // pointcut

    // joinpoint

    // weaving
}
