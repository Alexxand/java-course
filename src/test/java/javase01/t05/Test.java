package javase01.t05;


public class Test {
    private int n = 10;


    @org.junit.Test
    public void testToMakeX(){
        Matrix matrix = new Matrix(n);
        matrix.makeX();
        matrix.print();
    }
}
