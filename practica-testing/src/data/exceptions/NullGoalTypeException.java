package data.exceptions;

public class NullGoalTypeException extends Exception {
    public NullGoalTypeException() {
        super("The goal type is null");
    }
}
