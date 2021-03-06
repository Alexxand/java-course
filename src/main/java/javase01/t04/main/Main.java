package javase01.t04.main;

import javase01.t04.utils.Sequence;

public class Main{
    public static void main(String[] args){
        if (args.length < 1){
            System.out.println("Too few parameters. Usage: java javase01.t02.main.Main <elem1> <elem2> ... <elem2n>");
            return;
        }

        try {
            Sequence seq = new Sequence(args);
            System.out.println("Required value: " + seq.maxPairs());
        } catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}