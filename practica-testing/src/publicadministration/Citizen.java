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
        this.credCard =null;
    }

    public Nif getNif() { return nif; }

    public Date getExpDate() { return valDate; }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumb() {
        return phoneNumber;
    }

    public CreditCard getCredCard() {
        return credCard;
    }

    public CardPayment getLatestPayment() {
        return latestPayment;
    }

    public String toString () {
        return "Person{" +
                "nif=" + nif.toString() +
                ", expDate='" + valDate +
                ", name='" + name  +
                ", address='" + address  +
                ", mobileNumb='" + phoneNumber  +
                '}';

    } // converts to String

    public void setNif(Nif nif) { this.nif = nif; }

    public void setName(String name) { this.name = name; }

    public void setAddress(String address) { this.address = address; }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public void setValDate(Date valDate) { this.valDate = valDate; }

    public void setCredCard(CreditCard credCard) { this.credCard = credCard; }

    public void setLatestPayment(CardPayment cPay) { this.latestPayment = cPay; }

    public void copyCitizen(Citizen c) {
        this.nif = c.getNif();
        this.valDate = c.getExpDate();
        this.name = c.getName();
        this.address = c.getAddress();
        this.phoneNumber = c.getMobileNumb();
        this.credCard = c.getCredCard();
        this.latestPayment = c.getLatestPayment();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Citizen)) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equals(nif, citizen.nif) && Objects.equals(valDate, citizen.valDate) && Objects.equals(name, citizen.name) && Objects.equals(address, citizen.address) && Objects.equals(phoneNumber, citizen.phoneNumber) && Objects.equals(credCard, citizen.credCard) && Objects.equals(latestPayment, citizen.latestPayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nif, valDate, name, address, phoneNumber, credCard, latestPayment);

    }
}
