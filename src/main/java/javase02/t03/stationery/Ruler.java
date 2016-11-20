package javase02.t03.stationery;

import javase02.t03.utils.Color;
import javase02.t03.utils.MeasurementUnit;


public class Ruler extends MeasuringInstrument {
    public Ruler(String name, short cost){
        super(name,cost);
    }

    public Ruler(String name, short cost, MeasurementUnit unit, short range) {
        super(name, cost, unit, range);
    }

    public Ruler(String name, short cost, MeasurementUnit unit, short range, Color color) {
        super(name, cost, unit, range, color);
    }
}
