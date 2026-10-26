package com.ayush.SpringAopDemo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@Aspect
public class LoggingAspect {    //Proxy object

    //Advice
    @Before("execution(String com.ayush.SpringAopDemo.service.StudentService.createStudent(String)) && args(auth)")    //pointcut expression
    public void logBeforeMethod(String auth) {  //Should be called before createStudent() method of StudentService
            System.out.println("Student is going to be saved");
    }


    @AfterReturning(value = "execution(String com.ayush.SpringAopDemo.service.StudentService.createStudent(String)) && args(auth)",
    returning = "result")
    public void logAfterReturningMethod(String auth, String result){
        System.out.println("After Returning method called");
        System.out.println("Result is : " + result);
    }


    @AfterThrowing(value = "execution(String com.ayush.SpringAopDemo.service.StudentService.createStudent(String)) && args(auth)",
    throwing = "exception")
    public void logAfterThrowing(String auth, Throwable exception){
        System.out.println("After throwing method called");
        System.out.println("Exception Type : " + exception.getClass().getName());
        System.out.println("Exception Message : " + exception.getMessage());
    }


    @After("execution(String com.ayush.SpringAopDemo.service.StudentService.createStudent(String)) && args(auth)")
    public void logAfterMethod(String auth){
        System.out.println("Default After method called");
    }

    @Around("execution(String com.ayush.SpringAopDemo.service.StudentService.createStudent(String)) && args(auth)")
    public String logAroundMethod(ProceedingJoinPoint joinPoint, String auth) throws Throwable {

        System.out.println("in around : Before target method");

        try {
            String ans = (String) joinPoint.proceed(); //Calling the target method
            System.out.println("Target method executed successfully");
            ans = ans.toUpperCase(Locale.ROOT);
            return ans;
        }catch (Exception e){
            System.out.println("Target method execution failed");
            throw e;    //throwing exception to controller
        }
        finally {
            System.out.println("in around : After target method");
        }
    }
}
