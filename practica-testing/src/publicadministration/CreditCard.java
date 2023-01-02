package publicadministration;
import data.Nif;
import data.SmallCode;

import java.util.Date;


public class CreditCard {

    private Nif nif; // The nif of the user
    private String cardNumb; // The number of the credit card
    private Date expirDate; // The expiration date for the credit card
    private SmallCode svc; // The Safe Verification Code

    public CreditCard (Nif nif, String cardNum, Date expirDate, SmallCode svc) {
        this.nif = nif;
        this.cardNumb = cardNum;
        this.expirDate = expirDate;
        this.svc = svc;
    }

    public Nif getNif() {
        return nif;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public Date getExpirDate() {
        return expirDate;
    }

    public SmallCode getSvc() {
        return svc;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "nif=" + nif.toString() +
                ", cardNumb='" + cardNumb + '\'' +
                ", expirDate=" + expirDate.toString() +
                ", svc=" + svc.toString() +
                '}';
    } // converts to String

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreditCard that = (CreditCard) o;
        return nif.equals(that.nif) &&
                cardNumb.equals(that.cardNumb) &&
                expirDate.equals(that.expirDate) &&
                svc.equals(that.svc);
    }

    //set methods
    public void setNif(Nif nif) {
        this.nif = nif;
    }

    public void setCardNumb(String cardNumb) {
        this.cardNumb = cardNumb;
    }

    public void setExpirDate(Date expirDate) {
        this.expirDate = expirDate;
    }

    public void setSvc(SmallCode svc) {
        this.svc = svc;
    }
}
