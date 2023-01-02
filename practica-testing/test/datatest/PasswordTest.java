package datatest;
import data.Password;
import data.exceptions.InvalidPassword;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @Test
    void testCorrectPassword() throws InvalidPassword {
        Password password = new Password("12345678");
        assertEquals("12345678", password.getPassword());
    }

    @Test
    void testShortPassword(){
        Password password = new Password("1234567");
        Throwable exception = assertThrows(InvalidPassword.class, password::getPassword);
        assertEquals("La contrassenya ha de tenir com a minim 8 caracters", exception.getMessage());
    }

    @Test
    void testPasswordCannotBeNull(){
        Password password = new Password(null);
        Throwable exception = assertThrows(InvalidPassword.class, password::getPassword);
        assertEquals("La contrassenya ha de tenir com a minim 8 caracters", exception.getMessage());
    }

}
