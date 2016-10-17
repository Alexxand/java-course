package javase02.t02;


import javase02.t03.stationery.Stationery;

import java.util.ArrayList;
import java.util.List;

public class StocktakingStationery {
    private List<Stationery> stationeryList = new ArrayList<>();

    public boolean isNothing(){
        return true;
    }

    public boolean add(String name, int cost){
        return stationeryList.add(new Stationery(name,cost));
    }

    public boolean isThere(String name, int cost){
        return stationeryList.contains(new Stationery(name,cost));
    }

    public boolean remove(String name, int cost) {
        return stationeryList.remove(new Stationery(name,cost));
    }

    public int totalCost(){
        return stationeryList.stream().mapToInt(Stationery::getCost).sum();
    }
}
