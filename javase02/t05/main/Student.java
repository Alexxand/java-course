package javase02.t05.main;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Student {
    private String name;
    private String surname;
    private Integer age;
    private Sex sex;
    public enum Sex{
        MALE,
        FEMALE
    }
}
