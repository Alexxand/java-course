package javase03.t01;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CrazyLogger {
    final private StringBuilder log = new StringBuilder();

    public void info(CharSequence message){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        log.append(formattedDateTime).append(" – ").append(message).append('\n');
    }

    public void print(PrintStream stream) throws IOException{
        stream.print(log.toString());
    }

    public void print() throws IOException{
        this.print(System.out);
    }
}
