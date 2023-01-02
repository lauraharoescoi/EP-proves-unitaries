package services;

import data.Goal;
import publicadministration.Citizen;
import exceptions.*;

public interface GPD {

    boolean verifyData(Citizen persData, Goal goal) throws IncorrectVerificationException, ConnectException;

}
