package com.example.training.service;

import com.example.training.Data.Student;
import com.example.training.Data.StudentDTO_B;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Profile(value = "profile_B")
@Component
 class SearchInProfileB implements StudentService {
    ArrayList<Student> studentList = new ArrayList<>();

    public SearchInProfileB() {
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
