package documents;



public class PdfDocument implements Document {
    @Override
    public void open() {
        System.out.println("Opening PDF document (.pdf) in Read-Only mode...");
    }

    @Override
    public void save() {
        System.out.println("Exporting and saving PDF document.");
    }
}
