package data;

import data.exceptions.SmallCodeException;

public class SmallCode {
    private final String code;

    public SmallCode (String code) { this.code = code; }

    public String getCode () throws SmallCodeException {
        if (code == null) throw new SmallCodeException("Nombre secret no introduït");
        if (code.length() != 3) throw new SmallCodeException("El nombre secret és format per 3 digits");
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(code.charAt(i))) throw new SmallCodeException("El nobre secret no pot estar composat per lletres");
        }
        return code;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmallCode smallCode = (SmallCode) o;
        return code.equals(smallCode.code);
    }

    @Override
    public int hashCode () { return code.hashCode(); }

    @Override
    public String toString () {
        return "SmallCode{" + "code='" + code + '\'' + '}';
    }
}
