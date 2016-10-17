package javase01.t05;

/**
 * Created by alexmich on 08.10.16.
 */
public class Matrix {
    private int[][] data;

    public Matrix(int size){
        data = new int[size][size];
    }
    public int get(int i, int j) throws IndexOutOfBoundsException{
        try {
            return data[i][j];
        } catch (ArrayIndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    public void set(int i, int j, int value) throws IndexOutOfBoundsException{
        try {
            data[i][j] = value;
        } catch (ArrayIndexOutOfBoundsException e){
            throw new IndexOutOfBoundsException(e.getMessage());
        }
    }

    public void makeX(){
        int size = data.length;
        for(int i = 0; i < size; i++){
            data[i][i] = 1;
            data[i][size - 1 - i] = 1;
        }
    }
    public void print(){
        for (int[] arr: data){
            for(int elem: arr){
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }
}
