package exceptions;

public class NifNotRegisteredException extends Exception {
    public NifNotRegisteredException(String comment) {
        super(comment);
    }
}
