package javase02.t03.stationery;

import javase02.t03.utils.Color;
import javase02.t03.utils.MeasurementUnit;

/**
 * Created by alexmich on 09.10.16.
 */
public class Protractor extends MeasuringInstrument {
    public Protractor(String name, short cost){
        super(name,cost);
    }

    public Protractor(String name, short cost, MeasurementUnit unit, short range) {
        super(name, cost, unit, range);
    }

    public Protractor(String name, short cost, MeasurementUnit unit, short range, Color color) {
        super(name, cost, unit, range, color);
    }
}
