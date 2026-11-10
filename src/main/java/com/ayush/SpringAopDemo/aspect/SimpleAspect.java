package com.ayush.SpringAopDemo.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SimpleAspect {

//    @Before("execution(* com.ayush.SpringAopDemo.service..* (..))")
//    public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }
//
//        @Before("@annotation(com.ayush.SpringAopDemo.annotation.TrackExecutionTime)")
//        public void logBeforeMethod(){
//        System.out.println("Method Intercepted");
//    }

    @Around("@annotation(com.ayush.SpringAopDemo.annotation.TrackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

try {
    return joinPoint.proceed();
}

finally {
    long endTime = System.currentTimeMillis();

    long executionTime = endTime - startTime;

    System.out.println("Execution Time is : " + executionTime + " ms");
}

    }
}
