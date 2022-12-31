package data;

import data.exceptions.BadPathException;

public class DocPath {
    private final String path;

    public DocPath (String path) { this.path = path; }

    public String getPath () throws BadPathException {
        if (path == null) throw new BadPathException();
        return path;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DocPath docPath = (DocPath) o;
        return path.equals(docPath.path);
    }

    @Override
    public int hashCode () { return path.hashCode(); }

    @Override
    public String toString () {
        return "DocPath{" + "path='" + path + '\'' + '}';
    }
}