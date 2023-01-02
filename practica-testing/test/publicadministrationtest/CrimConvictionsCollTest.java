package publicadministrationtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.CrimConviction;
import publicadministration.CrimConvictionsColl;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CrimConvictionsCollTest {

    CrimConvictionsColl crimConvictionsColl;
    CrimConviction crimConviction;
    int numCrimes;

    @BeforeEach
    public void setUp() {
        crimConvictionsColl = new CrimConvictionsColl();
        crimConviction = new CrimConviction(new Date(), "Robo", "Prision");
        numCrimes = 0;
    }

    @Test
    void addCriminalConvictionTest() {
        crimConvictionsColl.addCriminalConviction(crimConviction);
        numCrimes = crimConvictionsColl.getNumCrimes();
        assertEquals(1, numCrimes);
    }

    @Test
    void getNumCrimesTest() {
        assertEquals(0, crimConvictionsColl.getNumCrimes());
    }

    @Test
    void getCriminalConvictionTest() {
        crimConvictionsColl.addCriminalConviction(crimConviction);
        assertEquals(crimConviction, crimConvictionsColl.getCriminalConviction(crimConviction.getCommitDate()));
    }

}
