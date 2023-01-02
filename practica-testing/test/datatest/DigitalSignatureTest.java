package datatest;
import data.DigitalSignature;
import data.exceptions.DigitalSignatureException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DigitalSignatureTest {


    @Test
    void testNullThrowsDigitalSignatureException(){
        DigitalSignature signature = new DigitalSignature(null);
        Throwable exception = assertThrows(DigitalSignatureException.class, signature::getSignature);
        assertEquals("The digital signature is null", exception.getMessage());
    }

}
