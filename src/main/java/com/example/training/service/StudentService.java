package com.example.training.service;

import com.example.training.Data.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public interface StudentService {
    ResponseEntity<?> search(Student student);
}

