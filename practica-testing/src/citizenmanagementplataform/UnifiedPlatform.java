package citizenmanagementplataform;

import data.DocPath;
import data.Goal;
import data.Nif;
import data.SmallCode;
import publicadministration.Citizen;
import publicadministration.CreditCard;

import java.util.*;

public class UnifiedPlatform {

    // Input events
    public void selectJusMin () { . . . };

    public void selectProcedures () { . . . };

    public void selectCriminalReportCertf () { . . . };

    public void selectAuthMethod (byte opc) { . . . };

    public void enterNIFandPINobt (Nif nif, Date valDate) { . . . } throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException;

    public void enterPIN (SmallCode pin) { . . . } throws NotValidPINException, ConnectException;

    private void enterForm (Citizen citz, Goal goal) { . . . } throws IncompleteFormException, IncorrectVerificationException, ConnectException;

    private void realizePayment () { . . . };

    private void enterCardData (CreditCard cardD) { . . . } throws IncompleteFormException, NotValidPaymentDataException, InsufficientBalanceException, ConnectException;

    private void obtainCertificate () { . . . } throws BadPathException, DigitalSignatureException, ConnectException;

    private void printDocument () { . . . } throws BadPathException, PrintingException;

    // Other internal operations (not required)
    private void registerPayment () { . . . };

    private void openDocument (DocPath path) { . . . } throws BadPathException;

    private void printDocument (DocPath path) { . . . } throws BadPathException, PrintingException;
}
