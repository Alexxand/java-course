package javase02.t04;

import javase02.t03.stationery.Stationery;

import java.util.Comparator;

/**
 * Created by alexmich on 11.10.16.
 */
public class StationeryComparatorMaker{


    public static Comparator<Stationery> make(Order order) {
        switch(order){
            default:
            case BY_NAME:
                return Comparator.comparing(Stationery::getName);
            case BY_COST:
                return Comparator.comparing(Stationery::getCost);
            case BY_COST_THEN_BY_NAME:
                return Comparator.comparing(Stationery::getCost).thenComparing(Stationery::getName);
        }
    }

    public enum Order{
        BY_NAME,
        BY_COST,
        BY_COST_THEN_BY_NAME
    }
}
