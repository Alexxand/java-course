package javase07.t02;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.MissingResourceException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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



    @Test
    public void multiThreadingTest() throws InterruptedException, ExecutionException{
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<BundleHandler> future1 = service.submit(() -> new BundleHandler("AnswerBundle_en.properties"));
        Future<BundleHandler> future2 = service.submit(() -> new BundleHandler("AnswerBundle_en.properties"));
        BundleHandler bundle1 = future1.get();
        BundleHandler bundle2 = future2.get();
        assertEquals("United Kingdom",bundle1.getValue("1"));
        assertEquals("United Kingdom",bundle2.getValue("1"));
    }
}
