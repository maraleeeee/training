package com.example.training.Data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.Nullable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Nullable
    private long id;
    @Nullable
    private String sId;
    @Nullable
    private String name;
    @Nullable
    private String family;
    @Nullable
    private int age;
    @Nullable
    private boolean isApplied;
}
