package javase04.t03;

import java.io.*;
import java.util.Arrays;

import static utils.Utils.getAbsoluteResourcePath;


public class Main {
    private static final int BUFFER_SIZE = 100;
    public static void main(String[] args){
        try (Reader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(getAbsoluteResourcePath("Example.java")),
                        "utf-8"
                )
        );
        Writer writer = new OutputStreamWriter(
                new FileOutputStream(getAbsoluteResourcePath("Example.utf-16.java")),
                "utf-16"
        )) {
            char[] buf = new char[BUFFER_SIZE];
            int nRead;
            while ((nRead = reader.read(buf)) != -1) {
                writer.write(buf,0,nRead);
            }

        } catch(IOException e){
            e.printStackTrace();
        }

    }
}
