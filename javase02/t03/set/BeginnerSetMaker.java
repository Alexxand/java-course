package javase02.t03.set;

import javase02.t03.stationery.*;

import java.util.ArrayList;
import java.util.List;

import static javase02.t03.utils.Color.*;
import static javase02.t03.utils.MeasurementUnit.*;

/**
 * Created by alexmich on 09.10.16.
 */
public class BeginnerSetMaker {
    public List<Stationery> make(){
        List<Stationery> set = new ArrayList<>(7);
        set.add(
                new Pen("blue pen", (short)20, (short)10, TRANSPARENT, BLUE)
        );
        set.add(
                new Pencil("simple pencil", (short)15, (short)10, GRAY)
        );
        set.add(
                new Ruler("centimetric ruler", (short)15, CENTIMETER, (short)15 ,DARK)
        );
        set.add(
                new Notebook("notebook",(short)30)
        );
        return set;
    };
}
