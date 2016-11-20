package javase04.t02;

import javase04.t01.KeyWordSearcher;

import java.io.*;

import static utils.Utils.getAbsoluteResourcePath;


public class Main {
    public static void main(String[] args){
        try(Reader reader = new BufferedReader(
                new FileReader(getAbsoluteResourcePath("Example.java"))
            );
            Writer writer = new FileWriter(
                    getAbsoluteResourcePath("keyWordsInExample.txt")
            )) {
            KeyWordSearcher searcher = KeyWordSearcher.search(reader);

            searcher.print(writer);
        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
