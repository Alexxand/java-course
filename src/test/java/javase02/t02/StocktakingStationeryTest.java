package javase02.t02;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StocktakingStationeryTest {
    @Test
    public void noStationeryAtFirst(){
        StocktakingStationery stocktaking = new StocktakingStationery();
        assertTrue(stocktaking.isNothing());
    }

    @Test
    public void addStationery(){
        StocktakingStationery stocktaking = new StocktakingStationery();
        assertTrue(stocktaking.add("pen",15));
        assertTrue(stocktaking.isThere("pen",15));
    }

    @Test
    public void removeStationery(){
        StocktakingStationery stocktaking = new StocktakingStationery();
        stocktaking.add("pen",15);
        assertTrue(stocktaking.remove("pen",15));
        assertTrue(!stocktaking.isThere("pen",15));
    }

    @Test
    public void calculateTotalCost(){
        StocktakingStationery stocktaking = new StocktakingStationery();
        stocktaking.add("pen",15);
        assertEquals(15,stocktaking.totalCost());
        stocktaking.add("ruler",20);
        assertEquals(15 + 20,stocktaking.totalCost());
        stocktaking.add("notebook",40);
        assertEquals(15+20+40,stocktaking.totalCost());
    }

    @Test
    public void totalCostIsZeroAtFirst(){
        StocktakingStationery stocktaking = new StocktakingStationery();
        assertEquals(0,stocktaking.totalCost());
    }
}
