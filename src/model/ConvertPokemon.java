package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import persistance.util.DatabaseConnector;
import persistance.util.SqlQueryStorage;

// Utilizzando il codice scritto in precedenza, scrivere un metodo statico chiamato "convertFromList2Array"
// che dato un ArrayList lo converte in un array di interi con gli indici che sono stati letti da un database.

//+ Scrivere un metodo che moltiplichi per 2 gli ID che hanno un indice pari e che divida per 3 quelli dispari.

public class ConvertPokemon {

  static Connection connection = DatabaseConnector.getConnection();

  public static void convertFromList2Array() {
    ArrayList<Integer> listaPokemonID = new ArrayList<>();
    Object[] myArray;

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        SqlQueryStorage.getAllPokemon
      );

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idResult = resultSet.getInt("id");
        listaPokemonID.add(idResult);
      }

      myArray = listaPokemonID.toArray();
      System.out.println(
        "La mia lista di id di Pokemon: " + Arrays.toString(myArray)
      );
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public static void multiplyDivideID() {
    ArrayList<Integer> listaPokemonID = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        SqlQueryStorage.getAllPokemon
      );

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idResult = resultSet.getInt("id");

        listaPokemonID.add(idResult);
      }
      for (int i = 0; i < listaPokemonID.size(); i++) {
        int k = listaPokemonID.get(i);
        if (k % 2 == 0) {
          int id = listaPokemonID.get(i);
          id = id * 2;
          listaPokemonID.set(i, id);
        } else {
          int id = listaPokemonID.get(i);
          id = id / 3;

          listaPokemonID.set(i, id);
        }
      }
      System.out.println(listaPokemonID);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
