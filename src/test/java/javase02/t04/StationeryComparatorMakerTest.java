package javase02.t04;


import javase02.t03.set.BeginnerSetMaker;
import javase02.t03.stationery.Stationery;
import org.junit.Test;

import java.util.List;

import static javase02.t04.StationeryComparatorMaker.Order.*;

/**
 * Created by alexmich on 11.10.16.
 */
public class StationeryComparatorMakerTest {

    private void print(List<? extends Stationery> set){
        for (Stationery elem: set) {
            System.out.println(elem);
        }
        System.out.println();
    }

    @Test
    public void byCost(){
        BeginnerSetMaker setMaker = new BeginnerSetMaker();
        List<Stationery> set = setMaker.make();
        System.out.println("byCost");
        System.out.println("Source set:");
        print(set);
        set.sort(StationeryComparatorMaker.make(BY_COST));
        System.out.println("Modified set:");
        print(set);

    }

    @Test
    public void byName(){
        BeginnerSetMaker setMaker = new BeginnerSetMaker();
        List<Stationery> set = setMaker.make();
        System.out.println("byName");
        System.out.println("Source set:");
        print(set);
        set.sort(StationeryComparatorMaker.make(BY_NAME));
        System.out.println("Modified set:");
        print(set);
    }

    @Test
    public void byCostThenByName(){
        BeginnerSetMaker setMaker = new BeginnerSetMaker();
        List<Stationery> set = setMaker.make();
        System.out.println("byCostThenByName");
        System.out.println("Source set:");
        print(set);
        set.sort(StationeryComparatorMaker.make(BY_COST_THEN_BY_NAME));
        System.out.println("Modified set:");
        print(set);

    }

}
