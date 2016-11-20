package javase06.t02;

import javase06.t02.BundleHandler;
import org.junit.Test;

import javax.management.AttributeList;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.MissingResourceException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

import static org.junit.Assert.assertEquals;


public class BundleHandlerTest {
    @Test(expected = FileNotFoundException.class)
    public void loadBundleFromNonexistentFile() throws IOException{
        BundleHandler bundle = new BundleHandler("Example.properies");
    }

    @Test
    public void getExistentKey() throws IOException{
        BundleHandler bundle = new BundleHandler("AnswerBundle_en.properties");
        assertEquals("Russia", bundle.getValue("4"));
    }

    @Test(expected = MissingResourceException.class)
    public void getNonexistentKey() throws IOException{
        BundleHandler bundle = new BundleHandler("AnswerBundle_en.properties");
        bundle.getValue("5");
    }
}
