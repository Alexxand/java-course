package javase02.t03.stationery;

/**
 * Created by alexmich on 09.10.16.
 */
public class Stationery {
    String name;
    short cost;

    public Stationery(String name, short cost) {
        this.name = name;
        this.cost = cost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCost(short cost) {
        this.cost = cost;
    }

    public short getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Stationery{" +
                "name='" + name + '\'' +
                ", cost=" + cost +
                '}';
    }
}
