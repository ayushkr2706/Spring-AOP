package com.ayush.SpringAopDemo.aspect;

import com.ayush.SpringAopDemo.annotation.TrackExecutionTime;
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

//    @Around("@annotation(com.ayush.SpringAopDemo.annotation.TrackExecutionTime)")
//    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
//
//        long startTime = System.currentTimeMillis();
//
//try {
//    return joinPoint.proceed();
//}
//
//finally {
//    long endTime = System.currentTimeMillis();
//
//    long executionTime = endTime - startTime;
//
//    System.out.println("Execution Time is : " + executionTime + " ms");
//}
//
//    }

    @Around("@annotation(trackExecutionTime)")
    public Object measureExecutionTime(ProceedingJoinPoint joinPoint,
                                     TrackExecutionTime trackExecutionTime) throws Throwable
    {
        long startTime = System.currentTimeMillis();

        try{
            return joinPoint.proceed();
        }
        finally{
            long endTime = System.currentTimeMillis();
            long totalDuration = endTime - startTime;

            if(totalDuration > trackExecutionTime.warnAfter()){
                System.out.println(trackExecutionTime.value());
                System.out.println("Total time taken is : " + totalDuration + " ms");
            }
            else{
                System.out.println("Total time taken is : " + totalDuration + " ms");
            }
        }
    }
}
