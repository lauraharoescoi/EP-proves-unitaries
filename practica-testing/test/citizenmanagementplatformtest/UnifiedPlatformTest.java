package citizenmanagementplatformtest;

import citizenmanagementplataform.UnifiedPlatform;
import data.Goal;
import data.Nif;
import data.SmallCode;
import data.exceptions.BadPathException;
import data.exceptions.DigitalSignatureException;
import data.exceptions.SmallCodeException;
import data.goalTypes;
import dummies.*;
import exceptions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.Citizen;
import publicadministration.CreditCard;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UnifiedPlatformTest {

    Citizen citizen;
    UnifiedPlatform platform;

    private Date valDate;

    ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    // Per a poder comprovar el contingut de la sortida estandard
    @BeforeEach
    void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams() {
        outContent.reset();
    }

    @BeforeEach
    public void setUp() {
        citizen = new Citizen();
        citizen.setName("Lorena");
        citizen.setNif(new Nif("12345678A"));
        citizen.setPhoneNumber("123456789");
        citizen.setAddress("Calle falsa 123");

        valDate = new Date();
        citizen.setValDate(valDate);

        platform = new UnifiedPlatform();
        platform.injectAuthenticationMethod(new CertificationAuthorityDumm(citizen));
    }


    @Test
    public void selectJustMinTest() throws ProceduralException {
        String expectedResult = "Es fa click en la secció Ministeri de Justicia del mosaïc inicial";
        platform.selectJusMin();
        assertEquals(expectedResult.strip(), outContent.toString().strip());
    }

    @Test
    public void selectProceduresSequence() throws ProceduralException {
        String expectedResult = "Es fa click en l'enllaç Tràmits dins la secció del Ministeri de Justicia";
        platform.selectJusMin();
        outContent.reset();
        platform.selectProcedures();
        assertEquals(expectedResult.strip(), outContent.toString().strip());
    }

    @Test
    public void selectCriminalReportCertfSequence() throws ProceduralException {
        String expectedResult = "Es selecciona el tramit per a obtindre el certificat d'antecedents penals";
        platform.selectJusMin();
        platform.selectProcedures();
        outContent.reset();
        platform.selectCriminalReportCertf();
        assertEquals(expectedResult.strip(), outContent.toString().strip());
    }

    @Test
    public void selectExistentAuthMethodTestSequence() throws ProceduralException {
        byte method = 3;
        String expectedResult = "Es selecciona el mètode d'autenticació Cl@ve Pin";
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        outContent.reset();
        platform.selectAuthMethod(method);
        assertEquals(expectedResult.strip(), outContent.toString().strip());
    }

    @Test
    public void selectProceduresWithStepsMissing() {
        Throwable exception = assertThrows(ProceduralException.class, platform::selectProcedures);
        assertEquals("Preconditions not accomplished",exception.getMessage());
    }

    @Test
    public void selectCriminalReportCertfWithStepsMissing() {
        Throwable exception = assertThrows(ProceduralException.class, platform::selectCriminalReportCertf);
        assertEquals("Preconditions not accomplished",exception.getMessage());
    }

    @Test
    public void selectExistentAuthMethodWithStepsMissing() {
        byte method = 3;
        Throwable exception = assertThrows(ProceduralException.class, () -> platform.selectAuthMethod(method));
        assertEquals("Preconditions not accomplished",exception.getMessage());
    }

    @Test
    public void NotValidPinTest() throws ProceduralException {
        //previous steps
        byte method = 3;
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(method);

        platform.injectAuthenticationMethod(new CertificationAuthorityDumm(citizen));

        Throwable exception = assertThrows(NotValidPINException.class, () -> platform.enterPIN(new SmallCode(null)));
        assertEquals("guarra",exception.getMessage());
    }

    @Test
    public void enterPinTest() throws ProceduralException, NotValidPINException, SmallCodeException, ConnectException {
        //previous steps
        byte method = 3;
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(method);
        outContent.reset();

        platform.injectAuthenticationMethod(new CertificationAuthorityDumm(citizen));

        String expectedResult2 = "[P] El PIN introduït correspon al generat pel sistema per aquest ciutadà i encara està vigent";
        platform.enterPIN(new SmallCode("123"));
        assertEquals(expectedResult2.strip(), outContent.toString().strip());
    }

    @Test
    public void realizePaymentTest() throws ProceduralException, NotValidPINException, SmallCodeException,
            ConnectException, IncompleteFormException, IncorrectVerificationException
    {
        //previous steps
        byte method = 3;
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(method);
        platform.injectAuthenticationMethod(new CertificationAuthorityDumm(citizen));
        platform.enterPIN(new SmallCode("123"));
        platform.injectGPD(new GPDDumm(citizen));
        platform.enterForm(citizen, new Goal(goalTypes.WORKWITHMINORS));
        outContent.reset();
        platform.realizePayment();
        assertEquals("Es selecciona l'opció realitzar pagament", outContent.toString().strip());


    }

    @Test
    public void ObtainCertificateTest() throws ProceduralException, NotValidPINException, SmallCodeException, ConnectException,
            IncompleteFormException, IncorrectVerificationException,
            NotValidPaymentDataException, InsufficientBalanceException,
            DigitalSignatureException, IOException, BadPathException
    {
        //previous steps
        byte method = 3;
        platform.selectJusMin();
        platform.selectProcedures();
        platform.selectCriminalReportCertf();
        platform.selectAuthMethod(method);
        platform.injectAuthenticationMethod(new CertificationAuthorityDumm(citizen));
        platform.enterPIN(new SmallCode("123"));
        platform.injectGPD(new GPDDumm(citizen));
        platform.enterForm(citizen, new Goal(goalTypes.WORKWITHMINORS));
        platform.realizePayment();
        CreditCard credC = new CreditCard(citizen.getNif(), "123", new Date(), new SmallCode("123"));
        platform.injectCAS(new CASDumm(credC));
        platform.enterCardData(credC);
        platform.injectJusticeMinistry(new JusticeMinistryDumm());
        outContent.reset();
        platform.obtainCertificate();
        assertEquals("Printing document . . .", outContent.toString().strip());
    }


}
