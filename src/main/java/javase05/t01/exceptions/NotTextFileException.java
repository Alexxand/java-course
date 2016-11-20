package javase05.t01.exceptions;

import java.io.IOException;

public class NotTextFileException extends IOException {
    public NotTextFileException() {
        super();
    }

    public NotTextFileException(String message) {
        super(message);
    }
}
