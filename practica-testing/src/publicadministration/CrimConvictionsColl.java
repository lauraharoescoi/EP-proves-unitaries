package publicadministration;

import java.util.Date;
import java.util.HashMap;

public class CrimConvictionsColl {

    HashMap<Date, CrimConviction> crimes;
    int numCrimes;

    public CrimConvictionsColl(){
        crimes = new HashMap<>();
        numCrimes = 0;
    }

    public void addCriminalConviction (CrimConviction crmC){
        crimes.put(crmC.getCommitDate(),crmC);
        numCrimes++;
    }

    public int getNumCrimes() {
        return numCrimes;
    }

    public CrimConviction getCriminalConviction (Date date){
        return crimes.get(date);
    }

    public String toString() {
        return "CrimConvictionsColl{" + "crimes=" + crimes + ", numCrimes=" + numCrimes + '}';
    }

}

