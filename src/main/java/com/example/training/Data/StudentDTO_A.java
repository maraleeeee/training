package com.example.training.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.annotation.Profile;

@Profile(value = "profile_A")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StudentDTO_A implements StudentDTO {
    private String sId;
    private String fullName;
    private int age;
    private boolean isApplied;


    public StudentDTO_A(Student s) {
        this.age = s.getAge();
        this.fullName = s.getName() + " " + s.getFamily();
        this.isApplied = s.isApplied();
        this.sId = s.getSId();

    }
}
