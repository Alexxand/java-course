package javase02.t04.comparators;

import javase02.t03.stationery.Stationery;

import java.util.Comparator;

/**
 * Created by alexmich on 11.10.16.
 */
public class NameStationeryComparator implements Comparator<Stationery> {

    @Override
    public int compare(Stationery o1, Stationery o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
