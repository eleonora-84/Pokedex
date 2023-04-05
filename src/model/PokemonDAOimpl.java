package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import persistance.util.DatabaseConnector;
import persistance.util.SqlQueryStorage;

public class PokemonDAOimpl implements PokemonDAO {

  Connection connection;

  public PokemonDAOimpl() {
    connection = DatabaseConnector.getConnection();
}

@Override
  public Pokemon createPokemon(Pokemon newPokemon) {
    try {
      // Nota: si parte da 1 e non da 0
      PreparedStatement preparedStatement = connection.prepareStatement(
        SqlQueryStorage.insertPokemon
      );
      preparedStatement.setString(1, newPokemon.getName());
      preparedStatement.setString(2, newPokemon.getElementType());
      preparedStatement.setInt(3, newPokemon.getLevel());

      int rowInserted = preparedStatement.executeUpdate();

      System.out.println(
        "LOG: Inserimento di " + rowInserted + " pokemon avvenuto con successo"
      );
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return newPokemon;
  }

  @Override
  public Pokemon getPokemonByID(int id) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        SqlQueryStorage.getPokemonByID
      );

      preparedStatement.setInt(1, id);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idResult = resultSet.getInt("id");
        String nameResult = resultSet.getString("name");
        String elementResult = resultSet.getString("elementType");
        int levelResult = resultSet.getInt("level");
        System.out.println(
          "Pokemon: id " +
          idResult +
          ", nome " +
          nameResult +
          ", elemento " +
          elementResult +
          ", livello " +
          levelResult
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public ArrayList<Pokemon> getAllPokemon() {
    
    ArrayList<Pokemon> listaPokemon = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        SqlQueryStorage.getAllPokemon
      );

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idResult = resultSet.getInt("id");
        String nameResult = resultSet.getString("name");
        String elementResult = resultSet.getString("elementType");
        int levelResult = resultSet.getInt("level");
        // System.out.println("Pokemon: id " + idResult + ", nome " + nameResult + ", elemento " + elementResult +", livello " + levelResult);
        listaPokemon.add(
          new Pokemon(idResult, nameResult, elementResult, levelResult)
        );
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return listaPokemon;
  }

  

  @Override
  public Pokemon updatePokemon(Pokemon newPokemon) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        SqlQueryStorage.updatePokemon
      );
      preparedStatement.setString(1, newPokemon.getName());
      preparedStatement.setString(2, newPokemon.getElementType());
      preparedStatement.setInt(3, newPokemon.getLevel());

      preparedStatement.setInt(4, newPokemon.getId());

      int rowUpdate = preparedStatement.executeUpdate();

      System.out.println(
        "LOG: Aggiornamento di " + rowUpdate + " pokemon avvenuto con successo"
      );
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return newPokemon;
  }

  @Override
  public void deletePokemonByID(int id) {
    try {
      PreparedStatement preparedStatement = connection.prepareStatement(
        SqlQueryStorage.deletePokemonByID
      );

      preparedStatement.setInt(1, id);

      int rowDelete = preparedStatement.executeUpdate();

      System.out.println(
        "LOG: Cancellazione di " + rowDelete + " pokemon avvenuto con successo"
      );
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void closeConnection() {
    try {
      connection.close();
      System.out.println("Connessione chiusa");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
