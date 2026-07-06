import documents.Document;
import factories.DocumentFactory;
import factories.ExcelFactory;
import factories.PdfFactory;
import factories.WordFactory;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Document Management System ===\n");

        // 1. Create a Word Document using WordFactory
        DocumentFactory wordFactory = new WordFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.save();

        System.out.println("---------------------------------");

        // 2. Create a PDF Document using PdfFactory
        DocumentFactory pdfFactory = new PdfFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.save();

        System.out.println("---------------------------------");

        // 3. Use the built-in factory workflow for Excel
        DocumentFactory excelFactory = new ExcelFactory();
        System.out.println("Using Factory Workflow for Excel:");
        excelFactory.processDocument(); 
    }
}