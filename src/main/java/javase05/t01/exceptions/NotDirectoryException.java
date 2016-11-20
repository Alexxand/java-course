package javase05.t01.exceptions;

import java.io.IOException;

public class NotDirectoryException extends IOException {
    public NotDirectoryException() {
        super();
    }

    public NotDirectoryException(String message) {
        super(message);
    }
}
