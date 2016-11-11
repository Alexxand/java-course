package javase04.t04;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Movie implements Serializable {
    private String name;
    private Person director;
    private int year;
}
