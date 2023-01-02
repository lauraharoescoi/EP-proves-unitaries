package data;

import data.exceptions.IncorrectNifException;

public class Nif {

    private final String nif;

    public Nif (String code) { this.nif = code; }


    public String getNif () throws IncorrectNifException {
        if (nif == null) throw new IncorrectNifException("NIF no introduït");
        if (nif.length() != 9) throw new IncorrectNifException("Longitud del NIF incorrecte");
        if (!Character.isLetter(nif.charAt(8))) throw new IncorrectNifException("És necessari introduir la lletra al final del NIF");
        for (int i = 0; i < 8; i++) {
            if (!Character.isDigit(nif.charAt(i))) throw new IncorrectNifException("El NIF no pot està composat de lletres");
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