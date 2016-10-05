package javase01.t04.utils;

public class Sequence{
    private double seq[];

    public Sequence(String[] elems) {
        int n = elems.length;
        seq = new double[n];
        for (int i = 0; i < n; ++i){
            seq[i] = Double.parseDouble(elems[i]);
        }
    }
    
    private static double max(double[] arr){
        int n = arr.length;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < n; ++i){
            if (max < arr[i])
                max = arr[i];
        }
        return max;
    }
    
    private double[] makePairsArr(){
        int n = seq.length/2;
        double[] arr = new double[n];
        for (int i = 0; i < n; ++i){
            arr[i] = seq[i] + seq[2*n - i - 1];
        }
        return arr;
    }
    
    public double maxPairs(){
        int n = seq.length;
        int i = 0;
        double[] newArr = this.makePairsArr();
        return max(newArr);
    }
}