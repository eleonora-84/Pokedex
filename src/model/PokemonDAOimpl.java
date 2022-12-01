package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            PreparedStatement preparedStatement = connection.prepareStatement(SqlQueryStorage.insertPokemon);
            preparedStatement.setString(1, newPokemon.getName());
            preparedStatement.setString(2, newPokemon.getElementType());
            preparedStatement.setInt(3, newPokemon.getLevel());
        
            int rowInserted = preparedStatement.executeUpdate();

            System.out.println("LOG: Inserimento di " + rowInserted + " avvenuto con successo");

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return newPokemon;
    }

    @Override
    public Pokemon getPokemonByID() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ArrayList<Pokemon> getAllPokemon() {
        // TODO Auto-generated method stub
        return null;
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
