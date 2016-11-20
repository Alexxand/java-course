package javase05.t01.exceptions;

import java.io.IOException;

public class FileAlreadyOpenedException extends IOException {
    public FileAlreadyOpenedException() {
        super();
    }

    public FileAlreadyOpenedException(String message) {
        super(message);
    }
}
