package com.example.training;

import com.example.training.Data.Student;
import com.example.training.Data.StudentDTO_A;
import com.example.training.Data.StudentDTO_B;
import com.example.training.service.StudentService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@TestPropertySource("classpath:application.properties")

public class ServicesTestProfileA {

    @Autowired
    StudentService studentService;

    @Test
    @RunOnProfile(value = "profile_A")
    public void testProfileA() {
        Student student = new Student();
        ResponseEntity<?> students = studentService.search(student);
        ArrayList<StudentDTO_A> studentList = new ArrayList<>();
        studentList.add(new StudentDTO_A("s1", "maral shojaee", 37, false));
        studentList.add(new StudentDTO_A("s2", "hosein habibi", 29, true));
        studentList.add(new StudentDTO_A("s3", "amir hesam soofali", 37, true));
        studentList.add(new StudentDTO_A("s4", "masoud moghini", 27, false));
        Assert.assertEquals(studentList, students.getBody());

        student.setName("maral");
        students=studentService.search(student);
        Assert.assertEquals(studentList.get(1),students);

    }

    @Test
    @Bean
    @Profile(value = "profile_B")
    public void testProfileB() {
        Student student = new Student();
        ResponseEntity<?> students = studentService.search(student);
        ArrayList<StudentDTO_B> studentList = new ArrayList<>();
        studentList.add(new StudentDTO_B("s1", "amin", "emadi", 30));
        studentList.add(new StudentDTO_B("s2", "parsa", "ebrahimi", 21));
        studentList.add(new StudentDTO_B("s3", "nazanin", "fereydooni zade", 24));
        studentList.add(new StudentDTO_B("s4", "zeynab", "sheykhi", 24));

        Assert.assertEquals(studentList, students.getBody());
    }
}
