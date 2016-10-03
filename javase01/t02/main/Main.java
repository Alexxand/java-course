package javase01.t02.main;

import javase01.t02.utils.Sequence;

public class Main{
    public static void main(String[] args){
        if (args.length < 2){
            System.out.println("Too few parameters. Usage: java javase01.t02.main.Main <number_of_elements> <epsilon>");
            return;
        }
        
        int n = Integer.parseInt(args[0]);
        double eps = Double.parseDouble(args[1]);
        
        Sequence seq = new Sequence(n);
        seq.print(4);
        int i = seq.findFirst(eps);
        if (i == -1)
            System.out.println("There isn't such element in the sequence");
        else
            System.out.println("Index of required element: " + i);
    }
}