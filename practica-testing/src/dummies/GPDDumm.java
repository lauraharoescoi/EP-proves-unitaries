package dummies;

import data.Goal;
import exceptions.ConnectException;
import exceptions.IncorrectVerificationException;
import publicadministration.Citizen;
import services.GPD;

public class GPDDumm implements GPD {
    Citizen citizen;

    public GPDDumm (Citizen citizen){
        this.citizen=citizen;
    }

    @Override
    public boolean verifyData(Citizen persData, Goal goal) throws IncorrectVerificationException, ConnectException {
        if(!persData.equals(citizen)) throw new IncorrectVerificationException("Camps introduits incorrectament");

        return true;
    }
}
