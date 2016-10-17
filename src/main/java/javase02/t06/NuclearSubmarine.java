package javase02.t06;

import javase02.t07.Info;
import javase02.t07.Month;

@Info(day = 14, month = Month.OCTOBER, year = 2016)
public class NuclearSubmarine {
    private NuclearReactor reactor = new NuclearReactor();

    public void run(){
        reactor.run();
        System.out.println("Nuclear submarine ran");
    }

    private class NuclearReactor{
        private void run(){
            System.out.println("Nuclear reactor ran");
        }
    }
}
