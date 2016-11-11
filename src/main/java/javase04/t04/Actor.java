package javase04.t04;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@EqualsAndHashCode
public class Actor extends Person {
    private String agencyName;

    Actor(String agencyName,String name, String surName, int age, Sex sex){
        super(name,surName,age,sex);
        this.agencyName = agencyName;
    }
}
