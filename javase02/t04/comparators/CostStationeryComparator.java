package javase02.t04.comparators;

import javase02.t03.stationery.Stationery;

import java.util.Comparator;

/**
 * Created by alexmich on 11.10.16.
 */
public class CostStationeryComparator implements Comparator<Stationery> {
    @Override
    public int compare(Stationery o1, Stationery o2) {
        if (o1.getCost() < o2.getCost())
            return -1;
        if (o1.getCost() == o2.getCost())
            return 0;
        return 1;
    }
}
