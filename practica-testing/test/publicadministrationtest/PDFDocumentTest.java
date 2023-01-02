package publicadministrationtest;

import data.DocPath;
import data.exceptions.BadPathException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import publicadministration.PDFDocument;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PDFDocumentTest {

    private PDFDocument pdf;
    private DocPath path;
    private File sourceFile;
    private File destFile;

    @BeforeEach
    public void setUp() throws BadPathException, IOException {
        sourceFile = new File("./PDFdoc2.pdf");
        sourceFile.createNewFile();
        pdf = new PDFDocument();
        path = new DocPath("PDFdoc2.pdf");
    }

    @Test
    public void testMoveDoc() throws IOException, BadPathException {
        DocPath destPath = new DocPath("PDFdoc2.pdf");
        pdf.moveDoc(destPath);
        assertEquals(destPath, pdf.getPath());
    }

    @Test
    public void testOpenDoc() throws IOException, BadPathException {
        pdf.openDoc(path);
    }

    @Test
    public void testGetPath() throws BadPathException {
        assertEquals(path, pdf.getPath());
    }

}

