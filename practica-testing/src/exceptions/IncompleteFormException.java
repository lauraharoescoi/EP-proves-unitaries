package exceptions;

public class IncompleteFormException extends Exception {
    public IncompleteFormException(String comment) {
        super(comment);
    }
}

