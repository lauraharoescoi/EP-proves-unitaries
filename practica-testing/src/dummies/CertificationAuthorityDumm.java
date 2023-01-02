package dummies;

import data.Nif;
import data.SmallCode;
import data.exceptions.SmallCodeException;
import exceptions.*;
import publicadministration.Citizen;
import services.CertificationAuthority;

import java.util.Date;

public class CertificationAuthorityDumm implements CertificationAuthority {
    Citizen citizen;

    public CertificationAuthorityDumm (Citizen citizen){
        this.citizen=citizen;
    }

    @Override
    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException {
        if(citizen.getNif()!=nif) throw new NifNotRegisteredException("NIF no existeix");
        if(citizen.getExpDate()!=date) throw new IncorrectValDateException("Data d'expiració incorrecta");
        if(citizen.getMobileNumb()==null) throw new AnyMobileRegisteredException("No s'ha introduit cap telèfon");
        return true;
    }

    @Override
    public boolean checkPIN(Nif nif, SmallCode pin) throws NotValidPINException, ConnectException, SmallCodeException {
        try{
            pin.getCode();
            return true;
        }
        catch (SmallCodeException e){throw new NotValidPINException("PIN incorrecte");}
    }
}
