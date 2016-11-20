package javase02.t03.stationery;

import javase02.t03.utils.Color;
import javase02.t03.utils.MeasurementUnit;

import static javase02.t03.utils.Color.*;
import static javase02.t03.utils.MeasurementUnit.*;


public class MeasuringInstrument extends Stationery {
    private Color color = TRANSPARENT;
    private MeasurementUnit unit = CENTIMETER;
    private short range = 10;

    public MeasuringInstrument(String name, short cost){
        super(name,cost);
    }

    public MeasuringInstrument(String name, short cost, MeasurementUnit unit, short range){
        this(name,cost);
        this.unit = unit;
        this.range = range;
    }

    public MeasuringInstrument(String name, short cost, MeasurementUnit unit, short range, Color color){
        this(name,cost,unit,range);
        this.color = color;
    }

    public void setUnit(MeasurementUnit unit) {
        this.unit = unit;
    }

    public MeasurementUnit getUnit() {
        return unit;
    }

    public void setRange(short range) {
        this.range = range;
    }

    public short getRange() {
        return range;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
