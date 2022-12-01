package persistance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    
    public static Connection getConnection(){

        Connection connection = null;

        try {
            Class.forName(CredentialStorage.className);
            connection = DriverManager.getConnection(CredentialStorage.dbAddress, CredentialStorage.user, CredentialStorage.password);

            if (connection != null){
                System.out.println("LOG: Connessione al database stabilita.");
            } else {
                System.out.println("WARNING: Connessione al database non riuscita.");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}


