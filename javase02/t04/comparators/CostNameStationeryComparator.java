package javase02.t04.comparators;

import javase02.t03.stationery.Stationery;

import java.util.Comparator;

/**
 * Created by alexmich on 11.10.16.
 */
public class CostNameStationeryComparator implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        Comparator<Stationery> byCost = new CostStationeryComparator();
        Comparator<Stationery> byName = new NameStationeryComparator();
        if(byCost.compare(o1,o2) == 0)
            return byName.compare(o1,o2);
        else
            return byCost.compare(o1,o2);
    }
}
