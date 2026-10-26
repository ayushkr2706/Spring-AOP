package com.ayush.SpringAopDemo.aspects;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {    //Proxy object

    //Advice
    @Before("execution(String com.ayush.SpringAopDemo.service.StudentService.createStudent(String)) && args(auth)")    //pointcut expression
    public void logBeforeMethod(String auth) {  //Should be called before createStudent() method of StudentService
            System.out.println("Student is going to be saved");
    }


    @AfterReturning("execution(String com.ayush.SpringAopDemo.service.StudentService.createStudent(String)) && args(auth)")
    public void logAfterReturningMethod(String auth){
        System.out.println("After Returning method called");
    }


    @AfterThrowing("execution(String com.ayush.SpringAopDemo.service.StudentService.createStudent(String)) && args(auth)")
    public void logAfterThrowing(String auth){
        System.out.println("After throwing method called");
    }


    @After("execution(String com.ayush.SpringAopDemo.service.StudentService.createStudent(String)) && args(auth)")
    public void logAfterMethod(String auth){
        System.out.println("Default After method called");
    }
}
