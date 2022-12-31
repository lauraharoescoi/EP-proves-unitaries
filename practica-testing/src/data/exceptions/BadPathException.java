package data.exceptions;

public class BadPathException extends Exception {
    public BadPathException() {
        super("The path does not exist");
    }
}
