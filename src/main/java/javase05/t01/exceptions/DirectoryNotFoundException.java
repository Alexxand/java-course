package javase05.t01.exceptions;


import java.io.IOException;

public class DirectoryNotFoundException extends IOException {
    public DirectoryNotFoundException() {
        super();
    }
    public DirectoryNotFoundException(String message) {
        super(message);
    }
}
