package data.exceptions;

public class SmallCodeException extends Exception {
    public SmallCodeException() {
        super("CVS code must be 3 digits");
    }
}
