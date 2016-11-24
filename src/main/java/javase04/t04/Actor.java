package javase04.t04;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Actor extends Person {
    private String agencyName;

    Actor(String agencyName,String name, String surName, int age, Sex sex){
        super(name,surName,age,sex);
        this.agencyName = agencyName;
    }

    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Actor)) return false;
        final Actor other = (Actor) o;
        if (!super.equals(other))  return false;
        if (this.agencyName == null ? other.agencyName != null : !this.agencyName.equals(other.agencyName))
            return false;
        return true;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + super.hashCode();
        result = result * PRIME + (agencyName == null ? 43 : agencyName.hashCode());
        return result;
    }
}
