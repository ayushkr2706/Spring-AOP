package com.ayush.SpringAopDemo.controller;

import com.ayush.SpringAopDemo.dto.StudentDto;
import com.ayush.SpringAopDemo.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDto> createStudent(@RequestHeader("Authorization") String auth,
                                                @RequestBody StudentDto student){
        StudentDto s = studentService.createStudent(auth, student);
        return ResponseEntity.ok().body(s);
    }

    @GetMapping
    public ResponseEntity<String> getStudent(){
        return ResponseEntity.ok(studentService.getStudent());
    }

    @GetMapping("/dummy")
    public ResponseEntity<String> dummyMethod(){
        String s = "ayush";
        return ResponseEntity.ok(studentService.dummyMethod(s));
    }
}
