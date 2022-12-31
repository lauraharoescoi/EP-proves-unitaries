package data.exceptions;

public class DigitalSignatureException extends Exception {
    public DigitalSignatureException() {
        super("The digital signature is null");
    }
}
