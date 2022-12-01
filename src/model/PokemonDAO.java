package model;

import java.util.ArrayList;

public interface PokemonDAO {
    
    //CRUD - create - read - update - delete
    public Pokemon createPokemon(Pokemon newPokemon);
    public Pokemon getPokemonByID(int id);
    public ArrayList<Pokemon> getAllPokemon();
    
    public Pokemon updatePokemon(Pokemon newPokemon);
    public void deletePokemonByID(int id);
    public void closeConnection();

}

