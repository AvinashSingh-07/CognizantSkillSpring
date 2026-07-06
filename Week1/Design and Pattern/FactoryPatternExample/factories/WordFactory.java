package factories;



import documents.Document;
import documents.WordDocument;

public class WordFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}
