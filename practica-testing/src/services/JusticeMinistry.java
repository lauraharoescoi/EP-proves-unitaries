package services;

import data.Goal;
import data.exceptions.BadPathException;
import data.exceptions.DigitalSignatureException;
import publicadministration.Citizen;
import exceptions.*;
import publicadministration.CriminalRecordCertf;

public interface JusticeMinistry {

    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g) throws DigitalSignatureException, ConnectException, BadPathException;

}

