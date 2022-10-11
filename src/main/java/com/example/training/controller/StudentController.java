package com.example.training.controller;


import com.example.training.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("student")
public class Student {

    StudentService studentService;

    @RequestMapping("/search")
    StudentDTO search() {

       return studentService.search();

    }

}
