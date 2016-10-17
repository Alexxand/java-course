package javase01.t03.utils;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alexmich on 07.10.16.
 */
public class FuncIOTable<E>{

    private List<Pair<E,E>> table = new ArrayList<>();


    public FuncIOTable(List<E> args, List<E> values){
        for (E arg: args){
            E value = values.get(args.indexOf(arg));
            Pair<E,E> pair = new Pair<>(arg, value);
            table.add(pair);
        }
    }

    public boolean add(E arg, E value){
        Pair<E,E> pair = new Pair<>(arg, value);
        return table.add(pair);
    }

    public void println() {
        for (Pair<E,E> pair: table) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

}
