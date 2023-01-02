package publicadministrationtest;

import data.Nif;
import data.SmallCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.CreditCard;

import java.util.Date;

public class CreditCardTest {
    CreditCard creditCard;
    Nif nif;
    String cardNumb;
    Date expirDate;
    SmallCode svc;

    @BeforeEach
    public void setUp() {
        nif = new Nif("12345678A");
        cardNumb = "1234567890123456";
        expirDate = new Date();
        svc = new SmallCode("123");
        creditCard = new CreditCard(nif, cardNumb, expirDate, svc);
    }

    @Test
    void getNifTest() {
        assertEquals(nif, creditCard.getNif());
    }

    @Test
    void getCardNumbTest() {
        assertEquals(cardNumb, creditCard.getCardNumb());
    }

    @Test
    void getExpirDateTest() {
        assertEquals(expirDate, creditCard.getExpirDate());
    }

    @Test
    void getSvcTest() {
        assertEquals(svc, creditCard.getSvc());
    }

}
