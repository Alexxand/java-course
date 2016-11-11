package javase04.t04;

import javase02.t05.Student;
import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Person implements Serializable{
    @NonNull private String name;
    @NonNull private String surName;
    @NonNull private int age;
    @NonNull private Sex sex;
    public enum Sex{
        MALE,
        FEMALE
    }
}
