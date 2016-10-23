package javase03.t01;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CrazyLoggerTest {
    @Test
    public void printMessage(){
        CrazyLogger log = new CrazyLogger();
        log.info("crazy message");
        log.print();
    }
}
