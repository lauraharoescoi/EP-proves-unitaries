package publicadministration;

import java.util.Date;

public class CrimConviction {

    private final Date commitDate;
    private final String offense;
    private final String sentence;

    public CrimConviction(Date commit, String off, String sentc){
        this.commitDate = commit;
        this.offense = off;
        this.sentence = sentc;
    }

    public Date getCommitDate() {
        return commitDate;
    }

    public String getOffense() {
        return offense;
    }

    public String getSentence() {
        return sentence;
    }

    public String toString () {
        return "CrimConviction{" + "commitDate=" + commitDate + ", offense='" + offense + '\'' + ", sentence='" + sentence + '\'' + '}';
    } // converts to String

}
