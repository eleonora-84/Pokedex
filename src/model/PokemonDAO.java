package model;

import java.util.ArrayList;

public interface PokemonDAO {
    
    //CRUD - create - read - update - delete
    public Pokemon createPokemon(Pokemon newPokemon);
    public Pokemon getPokemonByID();
    public ArrayList<Pokemon> getAllPokemon();
    public Pokemon updatePokemon();
    public void deletePokemon();
}

