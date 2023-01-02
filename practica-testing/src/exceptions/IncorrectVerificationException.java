package exceptions;

public class IncorrectVerificationException extends Exception {
    public IncorrectVerificationException(String comment) {
        super(comment);
    }
}
