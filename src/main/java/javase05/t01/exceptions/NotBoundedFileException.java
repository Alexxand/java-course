package javase05.t01.exceptions;

import java.io.IOException;

public class NotBoundedFileException extends IOException {
    public NotBoundedFileException() {
        super();
    }

    public NotBoundedFileException(String message) {
        super(message);
    }
}
