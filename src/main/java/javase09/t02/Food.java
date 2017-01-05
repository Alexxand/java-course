package javase09.t02;

import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class Food {
    int id;
    String name;
    double price;
    String description;
    int calories;
}
