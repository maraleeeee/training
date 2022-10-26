package com.example.training.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Profile;

@Profile(value = "profile_B")
@Data
@AllArgsConstructor
public class StudentDTO_B implements StudentDTO {
    private String sId;
    private String name;
    private String family;
    private int age;

    public StudentDTO_B(Student s) {
        this.age = s.getAge();
        this.name = s.getName();
        this.family = s.getFamily();
        this.sId = s.getSId();

    }
}
