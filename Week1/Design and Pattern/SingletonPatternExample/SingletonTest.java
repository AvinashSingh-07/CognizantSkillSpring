public class SingletonTest {

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log(null, "Application Started");
        logger2.log(null, "Logging Data");

        if (logger1 == logger2) {
            System.out.println("Only one Logger instance exists.");
        } else {
            System.out.println("Multiple Logger instances created.");
        }
    }
}

// Simple singleton Logger implementation for this example
class Logger {
    private static Logger instance;

    private Logger() {}

    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    // Simple log method matching usage in SingletonTest
    public void log(Object src, String message) {
        String prefix = (src == null) ? "" : src.toString() + ": ";
        System.out.println(prefix + message);
    }
}