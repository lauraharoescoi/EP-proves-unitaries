package publicadministration;

import data.DocPath;
import data.exceptions.BadPathException;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class  PDFDocument {
    private static final String DEF_PATH = "PDFdoc2.pdf";
    private Date creatDate;
    private DocPath path;
    private File file;

    public PDFDocument() throws BadPathException {
        creatDate = new Date();
        path = new DocPath(DEF_PATH);
        file = new File(path.getPath());
    }

    //setter methods
    public void setDate(Date date) { this.creatDate = date; }

    public void setPath(DocPath path) { this.path = path; }

    //getter methods
    public Date getDate() { return creatDate; }

    public DocPath getPath() { return path; }



    public void moveDoc(DocPath destPath) throws IOException, BadPathException {
        if(!new File(destPath.getPath()).exists()) throw new IOException("No s'ha trobat el path");
        else{
            Path sourcePath = Paths.get(path.getPath());
            Path newPath = Paths.get(destPath.getPath());
            Files.move(sourcePath, newPath, REPLACE_EXISTING);
            System.out.println("Document en path:" + path.getPath() + ", mogut a " + destPath.getPath());
            path = destPath;
        }

    }

    public void openDoc(DocPath path) throws IOException, BadPathException {
        if (!Desktop.isDesktopSupported()) {
            throw new IOException("Desktop not supported.");
        } else {
            file = new File(path.getPath());
            Desktop.getDesktop().open(file);
        }
    }

    public String toString () {
        return "PDFDocument{" + "creatDate=" + creatDate.toString() + ", path=" + path.toString() +'}';
    }
}
