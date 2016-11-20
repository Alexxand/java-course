package javase02.t03.stationery;

import javase02.t03.utils.Color;
import static javase02.t03.utils.Color.*;


public class WritingImlement extends Stationery{
    private short length = 10;
    private Color color = GRAY;

    public WritingImlement(String name, short cost){
        super(name,cost);
    }

    public WritingImlement(String name, short cost, short length, Color color){
        this(name, cost);
        this.length = length;
        this.color = color;
    }

    public void setLength(short length) {
        this.length = length;
    }

    public short getLength() {
        return length;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}