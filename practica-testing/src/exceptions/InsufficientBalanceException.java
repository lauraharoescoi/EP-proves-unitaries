package exceptions;

public class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String comment) {
        super(comment);
    }
}
