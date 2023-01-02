package publicadministrationtest;

import data.Nif;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.CardPayment;

import java.math.BigDecimal;
import java.util.Date;

public class CardPaymentTest {
    CardPayment cardPayment;
    Nif nif;
    BigDecimal imp;
    Date date;
    String reference;

    @BeforeEach
    public void setUp() {
        nif = new Nif("12345678A");
        imp = new BigDecimal(100);
        date = new Date();
        reference = "123456789";
        cardPayment = new CardPayment(nif, imp, date, reference);
    }

    @Test
    void getReferenceTest() {
        assertEquals(reference, cardPayment.getReference());
    }

    @Test

    void getNifTest() {
        assertEquals(nif, cardPayment.getNif());
    }

    @Test
    void getDateTest() {
        assertEquals(date, cardPayment.getDate());
    }

    @Test
    void getImpTest() {
        assertEquals(imp, cardPayment.getImp());
    }

}
