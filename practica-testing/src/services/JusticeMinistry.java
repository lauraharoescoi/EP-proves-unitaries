package services;

import data.Goal;
import publicadministration.Citizen;

public interface JusticeMinistry {

    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g) throws DigitalSignatureException,ConnectException7;

}
