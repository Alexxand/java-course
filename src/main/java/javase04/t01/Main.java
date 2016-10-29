package javase04.t01;

import java.io.*;

import static utils.Utils.getAbsoluteResourcePath;

/**
 * Created by alexmich on 30.10.16.
 */
public class Main {
    public static void main(String[] args){
        try(InputStream inputStream = new BufferedInputStream(
                new FileInputStream(getAbsoluteResourcePath("Example.java"))
            );
            OutputStream outputStream = new FileOutputStream(
                    getAbsoluteResourcePath("keyWordsInExample.txt")
            )) {
            KeyWordSearcher searcher = new KeyWordSearcher();
            searcher.search(inputStream);

            searcher.print(outputStream);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
