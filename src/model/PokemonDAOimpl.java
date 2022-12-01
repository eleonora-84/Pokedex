package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistance.SqlQueryStorage;
import persistance.util.DatabaseConnector;

public class PokemonDAOimpl implements PokemonDAO {

  @Override
  public Pokemon createPokemon(Pokemon newPokemon) {
    Connection connection = DatabaseConnector.getConnection();

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
        "LOG: Inserimento di " + rowInserted + " avvenuto con successo"
      );
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return newPokemon;
  }

  @Override
  public Pokemon getPokemonByID(int id) {
    Connection connection = DatabaseConnector.getConnection();

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
        System.out.println("Pokemon: id " + idResult + ", nome " + nameResult + ", elemento " + elementResult +", livello " + levelResult);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public ArrayList<Pokemon> getAllPokemon() {
    Connection connection = DatabaseConnector.getConnection();
    ArrayList<Pokemon> listaPokemon = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = connection.prepareStatement(SqlQueryStorage.getAllPokemon);

      ResultSet resultSet = preparedStatement.executeQuery();

      while (resultSet.next()) {
        int idResult = resultSet.getInt("id");
        String nameResult = resultSet.getString("name");
        String elementResult = resultSet.getString("elementType");
        int levelResult = resultSet.getInt("level");
        // System.out.println("Pokemon: id " + idResult + ", nome " + nameResult + ", elemento " + elementResult +", livello " + levelResult);
        listaPokemon.add(new Pokemon(idResult, nameResult, elementResult, levelResult));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return listaPokemon;
  }

  @Override
  public Pokemon updatePokemon() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deletePokemon() {
    // TODO Auto-generated method stub

  }
}
