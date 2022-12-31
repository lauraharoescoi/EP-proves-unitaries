package data.exceptions;

public class IncorrectNifException extends Exception {
    public IncorrectNifException() {
        super("The NIF is incorrect");
    }
}
