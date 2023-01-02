package publicadministrationtest;

//esta clase es la encargada de probar la clase CrimConviction

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.CrimConviction;

import java.util.Date;

public class CrimConvictionTest {
    CrimConviction crimConviction;
    Date date;

    @BeforeEach
    public void setUp() {
        date = new Date();
        crimConviction = new CrimConviction(date, "Robo", "Prision");
    }

    @Test
    void getCommitDateTest() {
        assertEquals(date, crimConviction.getCommitDate());
    }

    @Test
    void getOffenseTest() {
        assertEquals("Robo", crimConviction.getOffense());
    }

    @Test
    void getSentenceTest() {
        assertEquals("Prision", crimConviction.getSentence());
    }

}
