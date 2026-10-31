package com.ayush.SpringAopDemo.service;

import com.ayush.SpringAopDemo.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public class StudentService {   //Target object

    public StudentDto createStudent(String auth, StudentDto student){
        String authKey = auth.trim();
        if (!authKey.equals("12345")) {
            System.out.println("Auth key invalid");
            throw new RuntimeException("Auth Key is wrong");
        }
        System.out.println("Student saved");
        return student;
    }

    public String getStudent(){
        System.out.println("All Student Data");
        return "All Student Data";
    }

    public String dummyMethod(String s){
        System.out.println("dummyMethod called");
        return s;
    }
}
