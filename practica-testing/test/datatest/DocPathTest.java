package datatest;
import data.DocPath;
import data.exceptions.BadPathException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DocPathTest {

        @Test
        void testCorrectPath() throws BadPathException{
            DocPath path = new DocPath("C:/Users/user/Desktop/test.txt");
            assertEquals("C:/Users/user/Desktop/test.txt", path.getPath());
        }

        @Test
        void testnullThrowsBadPathException(){
            DocPath path = new DocPath(null);
            Throwable exception = assertThrows(BadPathException.class, path::getPath);
            assertEquals("The path does not exist", exception.getMessage());
        }

        @Test
        void testEmptyPath() throws BadPathException{
            DocPath path = new DocPath("");
            assertEquals("", path.getPath());
        }

}
