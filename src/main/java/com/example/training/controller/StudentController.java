package com.example.training.controller;


import com.example.training.Data.Student;
import com.example.training.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    StudentService studentService;

    public StudentController(StudentService studentService) {

        this.studentService = studentService;
    }

//    @RequestMapping("/search")
//    ResponseEntity<?>search() {
//
//       return  studentService.search();
//
//    }
    @RequestMapping("/search")
    ResponseEntity<?>search( Student student) {

        return  studentService.search(student);

    }
}
