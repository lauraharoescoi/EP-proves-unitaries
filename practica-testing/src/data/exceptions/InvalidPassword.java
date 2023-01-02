package data.exceptions;

public class InvalidPassword extends Exception {
    public InvalidPassword(String comment) {
        super(comment);
    }
}
