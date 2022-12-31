package publicadministration;

import data.Nif;

import java.math.BigDecimal;
import java.sql.Date;

public class CardPayment {

    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal imp; // The amount of the operation
    public CardPayment (Nif nif, BigDecimal imp) { . . . }

    @Override
    public String toString () { . . . } // converts to String
}
