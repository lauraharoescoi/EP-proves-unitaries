package data.exceptions;

public class BadPathException extends Exception {
    public BadPathException(String comment) {
        super(comment);
    }
}
