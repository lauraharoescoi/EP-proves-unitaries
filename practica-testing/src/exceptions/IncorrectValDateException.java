package exceptions;

public class IncorrectValDateException extends Exception {
    public IncorrectValDateException(String comment) {
        super(comment);
    }
}
