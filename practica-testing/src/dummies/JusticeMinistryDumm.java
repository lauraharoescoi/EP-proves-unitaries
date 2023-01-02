package dummies;

import data.DigitalSignature;
import data.Goal;
import data.exceptions.BadPathException;
import data.exceptions.DigitalSignatureException;
import exceptions.ConnectException;
import publicadministration.Citizen;
import publicadministration.CrimConvictionsColl;
import publicadministration.CriminalRecordCertf;

public class JusticeMinistryDumm implements services.JusticeMinistry {


    @Override
    public CriminalRecordCertf getCriminalRecordCertf(Citizen persD, Goal g) throws DigitalSignatureException, ConnectException, BadPathException {
        DigitalSignature ds = new DigitalSignature(new Byte[1010]);
        CrimConvictionsColl ccc = new CrimConvictionsColl();
        return new CriminalRecordCertf(persD.getNif(), persD.getName(), g,ds,ccc);
    }
}
