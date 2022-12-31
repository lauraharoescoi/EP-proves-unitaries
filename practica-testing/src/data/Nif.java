package data;

import data.exceptions.IncorrectNifException;

public class Nif {

    private final String nif;

    public Nif (String code) { this.nif = code; }


    public String getNif () throws IncorrectNifException {
        if (nif == null) throw new IncorrectNifException();
        if (nif.length() != 9) throw new IncorrectNifException();
        if (!Character.isLetter(nif.charAt(8))) throw new IncorrectNifException();
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(nif.charAt(i))) throw new IncorrectNifException();
        }
        return nif;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nif niff = (Nif) o;
        return nif.equals(niff.nif);
    }

    @Override
    public int hashCode () { return nif.hashCode(); }

    @Override
    public String toString () {
        return "Nif{" + "nif ciudadano='" + nif + '\'' + '}';
    }

}