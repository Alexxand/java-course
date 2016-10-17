package javase01.t02.utils;

public class Sequence{
    private double seq[];

    public Sequence(int n) {
        seq = new double[n];
        for (int i = 0; i < n; ++i){
            seq[i] = 1/(double)((i+1)*(i+1));
        }
    }
    
    public void print(int accuracy){
        System.out.print("Sequence: ");
        for (int i = 0; i < seq.length; ++i){
            System.out.printf("%." + accuracy + "f ", seq[i]);
        }
        System.out.println();
    }
    
    public int findFirst(double eps){
        int n = seq.length;
        int i = 0;
        while (i < n && seq[i] >= eps)
            ++i;
        if (i == n)
            return -1;
        return i;
    }
}