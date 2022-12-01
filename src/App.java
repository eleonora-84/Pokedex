import persistance.DatabaseManager;
import persistance.util.DatabaseConnector;

public class App {
    public static void main(String[] args) throws Exception {
        DatabaseConnector.getConnection();
        DatabaseManager dbManager = new DatabaseManager();
    }
}
