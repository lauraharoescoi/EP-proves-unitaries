package citizenmanagementplataform;

import data.*;
import data.exceptions.BadPathException;
import data.exceptions.DigitalSignatureException;
import data.exceptions.IncorrectNifException;
import data.exceptions.SmallCodeException;
import exceptions.NotValidPaymentDataException;
import jdk.jshell.spi.ExecutionControl;
import publicadministration.Citizen;
import publicadministration.CreditCard;
import exceptions.*;
import publicadministration.*;
import services.*;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.lang.Math;
import java.util.Date;

public class UnifiedPlatform {

    //The class members
    private final BigDecimal cost = new BigDecimal(3.86);
    Citizen citz;
    private states currentState;

    private GPD policeDepartment;
    private CertificationAuthority certMethod;
    private JusticeMinistry ministryMethod;
    private CAS paymentAuthority;

    private Goal goal;
    private DocPath localPath;
    private CardPayment currentPayment;


    public UnifiedPlatform (){
        this.citz = new Citizen();
        currentState = states.START;
        this.localPath = new DocPath("./Temporary.pdf");
    }

    // Input events
    public void selectJusMin () throws ProceduralException {
        if(currentState != states.START) throw new ProceduralException();
        currentState = states.SELECTEDJUSTMIN;
        System.out.println("Es fa click en la secció Ministeri de Justicia del mosaïc inicial");
    };

    public void selectProcedures () throws ProceduralException {
        if (currentState != states.SELECTEDJUSTMIN) throw new ProceduralException();
        currentState = states.SELECTINGPROCEDURES;
        System.out.println("Es fa click en l'enllaç Tràmits dins la secció del Ministeri de Justicia");
    };

    public void selectCriminalReportCertf () throws ProceduralException {
        if (currentState != states.SELECTINGPROCEDURES) throw new ProceduralException();
        currentState = states.SELECTINGAUTHMETHOD;
        System.out.println("Es selecciona el tramit per a obtindre el certificat d'antecedents penals");
    };

    public void selectAuthMethod (byte opc) throws ProceduralException {
        if (currentState != states.SELECTINGAUTHMETHOD) throw new ProceduralException();
        // ASSUMING THAT AUTH METHODS IN THE DICTIONARY WILL BE ON THE SAME ORDER AS IN THE WEB PAGE
        System.out.println("Es selecciona el mètode d'autenticació Cl@ve Pin");
        currentState = states.ENTERPIN;
    };

    public void enterNIFandPINobt (Nif nif, Date valDate) throws ProceduralException, NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, IncorrectNifException {

        if (currentState != states.ENTERPIN) throw new ProceduralException();
        citz.setNif(nif);  // We set the citizen nif to the one we got through parameter
        citz.setValDate(valDate);  // We set the citizen validation date to the one we got through parameter
        boolean res = certMethod.sendPIN(nif, valDate);
        if (res) {
            System.out.println("[P] S'envia el PIN a l'usuari amb DNI: " + nif.getNif());
        } else {
            throw new ConnectException("Error de connexió");
        }
    }

    public void enterPIN (SmallCode pin) throws NotValidPINException, ConnectException, ProceduralException, SmallCodeException {
        if (currentState != states.ENTERPIN) throw new ProceduralException();
        boolean res = certMethod.checkPIN(citz.getNif(), pin);
        if (res) {
            System.out.println("[P] El PIN introduït correspon al generat pel sistema per aquest ciutadà i encara està vigent");
        } else {
            System.out.println("[P] El PIN introduït no correspon al generat pel sistema per aquest ciutadà o ja no està vigent");
        }
        currentState = states.ENTERFORM;
    }

    public void enterForm (Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        if (currentState != states.ENTERFORM) throw new ProceduralException();
        Citizen tempCitz = new Citizen();
        tempCitz.copyCitizen(citz);
        this.goal = goal;
        policeDepartment.verifyData(tempCitz, goal);

        currentState = states.REALIZINGPAYMENT;
    }

    public void realizePayment () throws ProceduralException {
        if (currentState != states.REALIZINGPAYMENT) throw new ProceduralException();
        System.out.println("Es selecciona l'opció realitzar pagament");
        currentState = states.ENTERCARDDATA;
    }

    public void enterCardData (CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException, InsufficientBalanceException, ConnectException, ProceduralException {
        if (currentState != states.ENTERCARDDATA) throw new ProceduralException();
        CreditCard card = new CreditCard(cardD.getNif(), cardD.getCardNumb(), cardD.getExpirDate(), cardD.getSvc());
        citz.setCredCard(card);
        Integer reference = 100000000 + (int)(Math.random() * 999999999);
        CardPayment cPay = new CardPayment(citz.getNif(), cost, java.sql.Date.valueOf(java.time.LocalDate.now()), reference.toString());
        citz.setLatestPayment(cPay);

        paymentAuthority.askForApproval(cPay.getReference(), card, cPay.getDate(), cPay.getImp());

        currentPayment = cPay;

        currentState = states.OBTAININGCERTIFICATE;
    }

    public void obtainCertificate () throws ProceduralException, IOException, BadPathException, DigitalSignatureException, ConnectException{
        if (currentState != states.OBTAININGCERTIFICATE) throw new ProceduralException();
        CriminalRecordCertf doc = ministryMethod.getCriminalRecordCertf(citz, goal);
        doc.setPath(localPath);
        doc.setDate(java.sql.Date.valueOf(java.time.LocalDate.now()));
        doc.setGoal(goal);
        doc.setNif(citz.getNif());
        doc.setPayment(currentPayment);
        openDocument(doc.getPath());
        currentState = states.PRINTINGDOCUMENT;
        System.out.println("Printing document . . .");
    }

    public void injectAuthenticationMethod(CertificationAuthority method) {
        this.certMethod = method;
    }

    public void injectGPD(GPD method) {
        this.policeDepartment = method;
    }

    public void injectCAS(CAS method) {
        this.paymentAuthority = method;
    }

    public void injectJusticeMinistry(JusticeMinistry method) {
        this.ministryMethod = method;
    }

    // Other internal operations (not required)
    private void printDocument () throws BadPathException, PrintingException, ExecutionControl.NotImplementedException {
        if (!new File(localPath.getPath()).exists()) throw new BadPathException("L'adreça no existeix");
        System.out.println("[P] S'envia el document per a la seva impresió");
    }

    private void registerPayment () throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("Not required");
        //Al pdf diu k no fa falta implementacio???
    }

    private void openDocument (DocPath path) throws BadPathException, IOException {
        PDFDocument certPDF = new PDFDocument();
        certPDF.openDoc(path);
    }

    private void printDocument (DocPath path)throws BadPathException, PrintingException {
        //Al pdf diu k no fa falta implementacio???
    }
}
