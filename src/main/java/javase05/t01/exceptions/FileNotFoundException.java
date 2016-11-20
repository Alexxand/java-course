package javase05.t01.exceptions;


import java.io.IOException;

public class FileNotFoundException extends IOException {
    public FileNotFoundException() {
        super();
    }

    public FileNotFoundException(String message) {
        super(message);
    }
}
