package data.exceptions;

public class InvalidPassword extends Exception {
    public InvalidPassword() {
        super("Password must have at least 8 characters");
    }
}
