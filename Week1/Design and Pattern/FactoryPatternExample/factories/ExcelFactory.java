package factories;



import documents.Document;
import documents.ExcelDocument;

public class ExcelFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}
