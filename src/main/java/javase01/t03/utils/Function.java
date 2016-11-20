package javase01.t03.utils;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.floor;
import static java.lang.Math.tan;

public class Function {
    public static double func(final double x) {
        return tan(2 * x) - 3;
    }

    public static List<Double> func(final List<Double> inputArr) {
        List<Double> outputArr = new ArrayList<>();
        for (Double x : inputArr) {
            outputArr.add(func(x));
        }
        return outputArr;
    }

    public static FuncIOTable<Double> func(final double a, final double b, final double h) throws IllegalArgumentException {
        List<Double> args = getArgsList(a,b,h);
        List<Double> values = func(args);
        return new FuncIOTable<>(args,values);
    }

    private static List<Double> getArgsList(final double a, final double b, final double h) throws IllegalArgumentException {
        try {
            List<Double> list = new ArrayList<>((int) floor((b - a) / h + 1));
            for (double elem = a; elem < b; elem += h) {
                list.add(elem);
            }
            return list;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("b is less than a");
        }
    }
}
