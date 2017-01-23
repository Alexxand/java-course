package javase09.t02;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractParseTest {
    protected static final List<Food> expectedFoodList = new ArrayList<>();;
    protected List<Food> actualFoodList;

    @BeforeClass
    public static void initializePattern() {
        if (expectedFoodList.isEmpty()) {
            expectedFoodList.add(new Food(1, "Belgian Waffles", 5.95, "two of our famous Belgian Waffles with plenty of real maple syrup", 650));
            expectedFoodList.add(new Food(2, "Strawberry Belgian Waffles", 7.95, "light Belgian waffles covered with strawberrys and whipped cream", 900));
            expectedFoodList.add(new Food(3, "Berry-Berry Belgian Waffles", 8.95, "light Belgian waffles covered with an assortment of fresh berries and whipped cream", 900));
            expectedFoodList.add(new Food(4, "French Toast", 4.50, "thick slices made from our homemade sourdough bread", 600));
            expectedFoodList.add(new Food(5, "Homestyle Breakfast", 6.95, "two eggs, bacon or sausage, toast, and our ever-popular hash browns", 950));
        }
    }

    @Test
    abstract public void parseTest() throws Exception;

    @After
    public void compareLists(){
        assertEquals(expectedFoodList.size(),actualFoodList.size());
        Iterator<Food> expectedIterator = expectedFoodList.iterator();
        Iterator<Food> actualIterator = actualFoodList.iterator();
        while(expectedIterator.hasNext() && actualIterator.hasNext()){
            Food expected = expectedIterator.next();
            Food actual = actualIterator.next();
            assertEquals(expected,actual);
        }
    }

}
