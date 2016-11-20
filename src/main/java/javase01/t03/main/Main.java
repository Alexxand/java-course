package javase01.t03.main;

import javase01.t03.utils.Function;


public class Main {
    public static void main(String[] args)
    {
        if (args.length < 3){
            System.out.println("Too few parameters. Usage: java javase01.t03.main.Main a b h");
            return;
        }
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double h = Double.parseDouble(args[2]);
        System.out.println("Таблица значений:");
        try {
            Function.func(a, b, h).println();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
