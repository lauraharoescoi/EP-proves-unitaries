package exceptions;

public class NotValidPaymentDataException extends Exception {
    public NotValidPaymentDataException(String comment) {
        super(comment);
    }
}

