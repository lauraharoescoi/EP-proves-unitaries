package publicadministration;

import data.Nif;

import java.util.Date;

public class Citizen {

    private Nif nif;
    private Date valDate;
    private String name;
    private String address;
    private String phoneNumber;
    private CreditCard credCard;
    private CardPayment latestPayment;


    public Citizen() {
        this.name = null;
        this.nif = null;
        this.address = null;
        this.phoneNumber = null;
        this.valDate = null;
        this.credCard = null;
    }

    public Nif getNif() {
        return nif;
    }

    public Date getExpDate() {
        return valDate;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumb() {
        return phoneNumber;
    }

    public CardPayment getLatesPayment() {
        return latestPayment;
    }

    public String toString() {
        return "Person{" +
                "nif=" + nif.toString() +
                ", expDate='" + valDate +
                ", name='" + name +
                ", address='" + address +
                ", mobileNumb='" + phoneNumber +
                '}';

    } // converts to String

    public void setNif(Nif nif) {
        this.nif = nif;
    }

    public void setValDate(Date valDate) {
        this.valDate = valDate;
    }

    public void setCredCard(CreditCard credCard) {
        this.credCard = credCard;
    }

    public void setLatesPayment(CardPayment cPay) {
        this.latestPayment = cPay;
    }

    public void copyCitizen(Citizen c) {
        this.nif = c.getNif();
        this.valDate = c.getExpDate();
        this.name = c.getName();
        this.address = c.getAddress();
        this.phoneNumber = c.getMobileNumb();
        this.credCard = c.getCredCard();
        this.latestPayment = c.getLatesPayment();
    }
}
