package javase02.t01;

//import static Pen.Color.*;

public class Pen {

    public static final byte INK_AMOUNT = 90;
    public static final byte WRITTEN_INK_AMOUNT = 1;
    /**
     * Amount of ink in millimeters of refill.
     */
    private byte inkAmount = INK_AMOUNT;

    private boolean isButtonPressed = false;

    public void pressButton(){
        isButtonPressed = !isButtonPressed;
    }

    public boolean isButtonPressed(){
        return isButtonPressed;
    }

    public boolean write(){
        if (!isButtonPressed)
            return false;
        if (inkAmount <= 0)
            return false;
        inkAmount -= WRITTEN_INK_AMOUNT;
        return true;
    }

    public byte getInkAmount(){
        return inkAmount;
    }

    public boolean isUsedUp(){
        return inkAmount <= 0;
    }

    public void changeRefill(){
        inkAmount = INK_AMOUNT;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pen pen = (Pen) o;

        if (inkAmount != pen.inkAmount) return false;
        return isButtonPressed == pen.isButtonPressed;

    }

    @Override
    public int hashCode() {
        int result = (int) inkAmount;
        result = 31 * result + (isButtonPressed ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "inkAmount=" + inkAmount +
                ", isButtonPressed=" + isButtonPressed +
                '}';
    }
}
