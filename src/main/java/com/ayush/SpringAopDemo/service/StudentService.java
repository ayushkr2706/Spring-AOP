package com.ayush.SpringAopDemo.service;

import org.springframework.stereotype.Service;

@Service
public class StudentService {   //Target object

    public String createStudent(String auth){
        String authKey = auth.trim();
        if (!authKey.equals("12345")) {
            System.out.println("Auth key invalid");
            throw new RuntimeException("Auth Key is wrong");
        }
        System.out.println("Student saved");
        return "Student saved";
    }
}
