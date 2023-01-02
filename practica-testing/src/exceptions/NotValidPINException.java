package exceptions;

public class NotValidPINException extends Exception {
    public NotValidPINException(String comment) {
        super(comment);
    }
}
