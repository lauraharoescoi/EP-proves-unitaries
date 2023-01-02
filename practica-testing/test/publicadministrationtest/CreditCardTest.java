package publicadministrationtest;

import data.Nif;
import data.SmallCode;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.CreditCard;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void setNifTest() {
        Nif nif2 = new Nif("87654321A");
        creditCard.setNif(nif2);
        assertEquals(nif2, creditCard.getNif());
    }

    @Test
    void setCardNumbTest() {
        String cardNumb2 = "1234567890123457";
        creditCard.setCardNumb(cardNumb2);
        assertEquals(cardNumb2, creditCard.getCardNumb());
    }

    @Test
    void setExpirDateTest() {
        Date expirDate2 = new Date();
        creditCard.setExpirDate(expirDate2);
        assertEquals(expirDate2, creditCard.getExpirDate());
    }

    @Test
    void setSvcTest() {
        SmallCode svc2 = new SmallCode("456");
        creditCard.setSvc(svc2);
        assertEquals(svc2, creditCard.getSvc());
    }

}
