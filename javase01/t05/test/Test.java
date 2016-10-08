package javase01.t05.test;

import javase01.t05.main.Matrix;

/**
 * Created by alexmich on 08.10.16.
 */
public class Test {
    private int n = 10;


    @org.junit.Test
    public void testToMakeX(){
        Matrix matrix = new Matrix(n);
        matrix.makeX();
        matrix.print();
    }
}
