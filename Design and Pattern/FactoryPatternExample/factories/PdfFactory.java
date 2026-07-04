package factories;



import documents.Document;
import documents.PdfDocument;

public class PdfFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PdfDocument();
    }
}
