package publicadministration;

import data.DigitalSignature;
import data.Goal;
import data.Nif;
import publicadministration.CrimConvictionsColl;

public class CriminalRecordCertf {
    private Nif nif;
    private String name;
    private Goal goal;
    private DigitalSignature digSign;
    private CrimConvictionsColl crimConvs;

    public CriminalRecordCertf (Nif nif, String name, Goal g, DigitalSignature ds, CrimConvictionsColl crmC) { . . . }
}
