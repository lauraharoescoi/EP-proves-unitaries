package exceptions;

public class ConnectException extends Exception {
    public ConnectException(String comment) {
        super(comment);
    }
}
