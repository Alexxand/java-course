package javase01.t04.utils;

public class Sequence{
    private double seq[];

    public Sequence(String[] elems) throws IllegalArgumentException {
        int n = elems.length;

        if (n%2 != 0)
            throw new IllegalArgumentException("Number of elements have to be even");

        seq = new double[n];
        for (int i = 0; i < n; ++i){
            seq[i] = Double.parseDouble(elems[i]);
        }
    }
    
    private static double max(double[] arr){
        int n = arr.length;
        double max = Double.MIN_VALUE;
        for (double cur : arr){
            if (max < cur)
                max = cur;
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
        double[] newArr = this.makePairsArr();
        return max(newArr);
    }
}