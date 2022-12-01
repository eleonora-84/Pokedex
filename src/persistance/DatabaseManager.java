package persistance;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import persistance.util.DatabaseConnector;

public class DatabaseManager {

  public DatabaseManager() {
    initDB();
  }

  public void initDB() {
    /* DDL Di creazione del database */
    Connection connection = DatabaseConnector.getConnection();
    try {
      Statement st = connection.createStatement();
      st.executeUpdate(SqlQueryStorage.createPokemonTable);

      System.out.println("LOG: Tabelle create");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
