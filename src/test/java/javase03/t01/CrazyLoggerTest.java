package javase03.t01;

import org.junit.Test;

import java.io.IOException;

public class CrazyLoggerTest {
    @Test
    public void simpleMessageTest() throws IOException{
        CrazyLogger log = new CrazyLogger();
        log.info("crazy message");
        log.print();
    }
}
