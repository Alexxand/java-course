package javase02.t04.test;


import javase02.t03.set.BeginnerSetMaker;
import javase02.t03.stationery.Stationery;
import javase02.t04.comparators.CostStationeryComparator;
import javase02.t04.comparators.CostNameStationeryComparator;
import javase02.t04.comparators.NameStationeryComparator;
import org.junit.Test;

import java.util.List;

/**
 * Created by alexmich on 11.10.16.
 */
public class ComparatorsTest {

    private void print(List<? extends Stationery> set){
        for (Stationery elem: set) {
            System.out.println(elem);
        }
        System.out.println();
    }

    @Test
    public void byCostTest(){
        BeginnerSetMaker setMaker = new BeginnerSetMaker();
        List<Stationery> set = setMaker.make();
        System.out.println("byCostTest");
        System.out.println("Source set:");
        print(set);
        set.sort(new CostStationeryComparator());
        System.out.println("Modified set:");
        print(set);

    }

    @Test
    public void byNameTest(){
        BeginnerSetMaker setMaker = new BeginnerSetMaker();
        List<Stationery> set = setMaker.make();
        System.out.println("byNameTest");
        System.out.println("Source set:");
        print(set);
        set.sort(new NameStationeryComparator());
        System.out.println("Modified set:");
        print(set);
    }

    @Test
    public void byNameCostTest(){
        BeginnerSetMaker setMaker = new BeginnerSetMaker();
        List<Stationery> set = setMaker.make();
        System.out.println("byNameCostTest");
        System.out.println("Source set:");
        print(set);
        set.sort(new CostNameStationeryComparator());
        System.out.println("Modified set:");
        print(set);

    }

}
