package exceptions;

public class PrintingException extends Exception {
    public PrintingException(String comment) {
        super(comment);
    }
}
