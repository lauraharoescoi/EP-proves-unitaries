package datatest;
import data.SmallCode;
import data.exceptions.SmallCodeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmallCodeTest {

    @Test
    void testCorrectSmallCode() throws SmallCodeException {
        SmallCode smallCode = new SmallCode("123");
        assertEquals("123", smallCode.getCode());
    }

    @Test
    void testShortSmallCode(){
        SmallCode smallCode = new SmallCode("12");
        Throwable exception = assertThrows(SmallCodeException.class, smallCode::getCode);
        assertEquals("El nombre secret és format per 3 digits", exception.getMessage());
    }

    @Test
    void testLongSmallCode(){
        SmallCode smallCode = new SmallCode("1234");
        Throwable exception = assertThrows(SmallCodeException.class, smallCode::getCode);
        assertEquals("El nombre secret és format per 3 digits", exception.getMessage());
    }

    @Test
    void testSmallCodeWithLetters(){
        SmallCode smallCode = new SmallCode("12a");
        Throwable exception = assertThrows(SmallCodeException.class, smallCode::getCode);
        assertEquals("El nobre secret no pot estar composat per lletres", exception.getMessage());
    }

    @Test
    void testCodeCannotBeNull(){
        SmallCode smallCode = new SmallCode(null);
        Throwable exception = assertThrows(SmallCodeException.class, smallCode::getCode);
        assertEquals("Nombre secret no introduït", exception.getMessage());
    }

}
