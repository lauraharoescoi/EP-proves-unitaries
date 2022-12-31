package services;

import publicadministration.CreditCard;

import java.math.BigDecimal;
import java.util.Date;

public interface CAS {

    boolean askForApproval(String nTrans, CreditCard cardData, Date date, BigDecimal imp)
            throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException;

}