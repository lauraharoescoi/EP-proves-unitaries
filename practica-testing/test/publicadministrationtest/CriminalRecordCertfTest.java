package publicadministrationtest;

import data.*;
import data.exceptions.BadPathException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.CardPayment;
import publicadministration.CrimConvictionsColl;
import publicadministration.CriminalRecordCertf;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CriminalRecordCertfTest {

    CriminalRecordCertf criminalRecordCertf;
    Nif nif;
    String name;
    Goal goal;
    DigitalSignature digSign;
    CrimConvictionsColl crimConvs;
    CardPayment payment;

    @BeforeEach
    public void setUp() throws BadPathException {
        nif = new Nif("12345678A");
        name = "John";
        goal = new Goal(goalTypes.WORKWITHMINORS);
        digSign = new DigitalSignature(new Byte[0]);
        crimConvs = new CrimConvictionsColl();
        payment = new CardPayment(nif, new BigDecimal(100), new Date(), "1234");
        criminalRecordCertf = new CriminalRecordCertf(nif, name, goal, digSign, crimConvs);
        criminalRecordCertf.setPayment(payment);
    }

    @Test
    void testGetNif() {
        assertEquals(nif, criminalRecordCertf.getNif());
    }

    @Test
    void testGetName() {
        assertEquals(name, criminalRecordCertf.getName());
    }

    @Test
    void testGetGoal() {
        assertEquals(goal, criminalRecordCertf.getGoal());
    }

    @Test
    void testGetDigSign() {
        assertEquals(digSign, criminalRecordCertf.getDigSign());
    }

    @Test
    void testGetCrimConvs() {
        assertEquals(crimConvs, criminalRecordCertf.getCrimConvs());
    }

    @Test
    void testGetPayment() {
        assertEquals(payment, criminalRecordCertf.getPayment());
    }

    //test setters

    @Test
    void testSetDate() {
        Date date = new Date();
        criminalRecordCertf.setDate(date);
        assertEquals(date, criminalRecordCertf.getDate());
    }

    @Test
    void testSetPath() {
        DocPath path = new DocPath("./");
        criminalRecordCertf.setPath(path);
        assertEquals(path, criminalRecordCertf.getPath());
    }

    @Test
    void testSetGoal() {
        Goal goal = new Goal(goalTypes.WORKWITHMINORS);
        criminalRecordCertf.setGoal(goal);
        assertEquals(goal, criminalRecordCertf.getGoal());
    }

    @Test
    void testSetNif() {
        Nif nif = new Nif("12345678B");
        criminalRecordCertf.setNif(nif);
        assertEquals(nif, criminalRecordCertf.getNif());
    }

    @Test
    void testSetName() {
        String name = "John";
        criminalRecordCertf.setName(name);
        assertEquals(name, criminalRecordCertf.getName());
    }


}
