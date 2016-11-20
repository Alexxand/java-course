package javase02.t03.stationery;

import javase02.t03.utils.Color;

import static javase02.t03.utils.Color.*;


public class Pen extends WritingImlement {
    Color color = TRANSPARENT;
    Color inkColor = BLUE;


    public Pen(String name, short cost){
        super(name,cost);
    }

    public Pen(String name, short cost, short length, Color color) {
        super(name, cost, length, color);
    }

    public Pen(String name, short cost, short length, Color color, Color inkColor) {
        this(name, cost, length, color);
        this.inkColor = inkColor;
    }
}
