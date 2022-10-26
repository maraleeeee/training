package com.example.training.service;

import com.example.training.Data.Student;
import com.example.training.Data.StudentDTO_A;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Profile(value = "profile_A")
@Component
class SearchInProfileA implements StudentService {
    ArrayList<Student> studentList = new ArrayList<>();

    public SearchInProfileA() {
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
