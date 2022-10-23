package com.example.training.service;

import com.example.training.Data.Student;
import com.example.training.Data.StudentDTO;
import com.example.training.Data.StudentDTO_A;
import com.example.training.Data.StudentDTO_B;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public interface StudentService {
    ResponseEntity<?> search(Student student);
}

@Profile(value = "profile_A")
@Component
class searchInProfileA implements StudentService {
    ArrayList<Student> studentList = new ArrayList<>();

    public searchInProfileA() {
        studentList.add(new Student(1, "s1", "maral", "shojaee", 37, false));
        studentList.add(new Student(2, "s2", "hosein", "habibi", 29, true));
        studentList.add(new Student(3, "s3", "amir hesam", "soofali", 37, true));
        studentList.add(new Student(4, "s4", "masoud", "moghini", 27, false));

    }


    @Override
    public ResponseEntity<?> search(Student student) {
        List<Student> sl = studentList.stream()
                .filter(s ->
                        s.getName() != null && s.getName().toLowerCase().contains(((student.getName() == null) ? "" : student.getName())))
                .filter(s ->
                        s.getFamily() != null && s.getFamily().toLowerCase().contains(((student.getFamily() == null) ? "" : student.getFamily())))
                .filter(s ->
                        s.getSId() != null && s.getSId().toLowerCase().contains(((student.getSId() == null) ? "" : student.getSId()))
                ).toList();
        return ResponseEntity.of(Optional.of(sl.stream().map(StudentDTO_A::new).toList()));


    }
}

@Profile(value = "profile_B")
@Component
class searchInProfileB implements StudentService {
    ArrayList<Student> studentList = new ArrayList<>();

    public searchInProfileB() {
        studentList.add(new Student(1, "s1", "amin", "emadi", 30, false));
        studentList.add(new Student(2, "s2", "parsa", "ebrahimi", 21, false));
        studentList.add(new Student(3, "s3", "nazanin", "fereydooni zade", 24, false));
        studentList.add(new Student(4, "s4", "zeynab", "sheykhi", 24, false));

    }


    @Override
    public ResponseEntity<?> search(Student student) {
        List<Student> sl = new ArrayList<>();
        for (Student a : studentList) {
            if (!(a.getName() != null && a.getName().toLowerCase().contains(((student.getName() == null) ? "" : student.getName()))))
                continue;
            if (!(a.getFamily() != null && a.getFamily().toLowerCase().contains(((student.getFamily() == null) ? "" : student.getFamily()))))
                continue;
            if (!(a.getSId() != null && a.getSId().toLowerCase().contains(((student.getSId() == null) ? "" : student.getSId()))))
                continue;
            sl.add(a);
        }
        return ResponseEntity.of(Optional.of(sl.stream().map(StudentDTO_B::new).toList()));

    }
}