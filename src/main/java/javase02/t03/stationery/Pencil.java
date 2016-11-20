package javase02.t03.stationery;

import javase02.t03.utils.Color;


public class Pencil extends WritingImlement {
    public Pencil(String name, short cost){
        super(name,cost);
    }

    public Pencil(String name, short cost, short length, Color color) {
        super(name, cost, length, color);
    }
}
