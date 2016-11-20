package javase05.t01.exceptions;

import java.io.IOException;

/**
 * Created by alexmich on 20.11.16.
 */
public class NotDirectoryException extends IOException {
    public NotDirectoryException() {
        super();
    }

    public NotDirectoryException(String message) {
        super(message);
    }
}
