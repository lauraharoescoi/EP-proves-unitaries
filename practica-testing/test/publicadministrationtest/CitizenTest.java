package publicadministrationtest;

import data.Nif;
import data.SmallCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.CardPayment;
import publicadministration.Citizen;
import publicadministration.CreditCard;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CitizenTest {
    Citizen citizen;
    private Date date;
    private BigDecimal imp;

    @BeforeEach
    public void setUp() {
        citizen = new Citizen();
        date = new Date();
        citizen.setNif(new Nif("12345678A"));
        citizen.setName("John");
        citizen.setAddress("Calle 1");
        citizen.setPhoneNumber("123456789");
        citizen.setValDate(date);
        citizen.setCredCard(new CreditCard(citizen.getNif(), "1234567890123456", date, new SmallCode("123")));
        citizen.setLatestPayment(new CardPayment(citizen.getNif(), new BigDecimal(100), date, "1234"));
    }

    @Test
    void testGetNif() {
        assertEquals(citizen.getNif(), citizen.getNif());
    }

    @Test
    void testGetName() {
        assertEquals(citizen.getName(), citizen.getName());
    }

    @Test
    void testGetAddress() {
        assertEquals(citizen.getAddress(), citizen.getAddress());
    }

    @Test
    void testGetPhoneNumber() {
        assertEquals(citizen.getMobileNumb(), citizen.getMobileNumb());
    }

    @Test
    void testGetValDate() {
        assertEquals(citizen.getExpDate(), citizen.getExpDate());
    }

    @Test
    void testGetCredCard() {
        assertEquals(citizen.getCredCard(), citizen.getCredCard());
    }

    @Test
    void testGetLatestPayment() {
        assertEquals(citizen.getLatestPayment(), citizen.getLatestPayment());
    }

}
