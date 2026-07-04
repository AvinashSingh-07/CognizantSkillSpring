package factories;



import documents.Document;

public abstract class DocumentFactory {
    // The Factory Method
    public abstract Document createDocument();

    // An optional helper method demonstrating that factories often contain business logic
    public void processDocument() {
        Document doc = createDocument();
        doc.open();
        doc.save();
    }
}
