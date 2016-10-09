package javase02.t01.pen;

import static javase02.t01.pen.Pen.Color.*;

/**
 * Created by alexmich on 09.10.16.
 */
public class Pen {
    /**
     * Ink's color.
     */
    private Color color;
    /**
     * Amount of ink in millimeters of refill.
     */
    private byte inkAmount;

    public Pen() {
        this(DARK, (byte) 90);
    }

    public Pen(Color color, byte inkAmount){
        this.color = color;
        this.inkAmount = inkAmount;
    }

    public void changeRefill(Color color, byte inkAmount){
        this.color = color;
        this.inkAmount = inkAmount;
    }

    public void write(byte waste){
        if (inkAmount >= waste)
            inkAmount -= waste;
        else
            inkAmount = (byte)0;
    }

    public Color getColor(){
        return color;
    }

    public boolean isWasted(){
        return inkAmount == (byte)0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (inkAmount != pen.inkAmount) return false;
        return color == pen.color;

    }

    @Override
    public int hashCode() {
        int result = color != null ? color.hashCode() : 0;
        result = 31 * result + (int) inkAmount;
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "color=" + color +
                ", inkAmount=" + inkAmount +
                '}';
    }

    public enum Color{
        DARK,
        BLUE,
        GREEN,
        RED;

        @Override
        public String toString() {
            return super.toString().toLowerCase();
        }
    }
}
