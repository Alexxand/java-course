package javase03.t01;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * You can use this class for logging messages in your project
 */
public class CrazyLogger {
    final private StringBuilder log = new StringBuilder();

    /**
     * Memorize your message. It uses format dd-mm-yyyy : hh-mm – message.
     * You can write all messages from the log into a file or into the standard output stream using {@link CrazyLogger#print(PrintStream)} or {@link CrazyLogger#print()}
     * @param message The message to be logged
     */
    public void info(CharSequence message){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY : hh-mm");
        String formattedDateTime = LocalDateTime.now().format(formatter);
        log.append(formattedDateTime).append(" – ").append(message).append('\n');
    }

    /**
     * Write all log into a printStream.
     * @param stream printStream to be written in.
     */
    public void print(PrintStream stream){
        stream.print(log.toString());
    }

    /**
     * Write all log into the standard output stream.
     */
    public void print(){
        this.print(System.out);
    }
}
