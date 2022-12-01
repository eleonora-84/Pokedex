import model.Pokemon;
import model.PokemonDAO;
import model.PokemonDAOimpl;
import persistance.DatabaseManager;

public class PokemonDatabase {
    private DatabaseManager databaseManager;
    private PokemonDAO pokemonDAO;

    public PokemonDatabase() {
        databaseManager = new DatabaseManager();
        pokemonDAO = new PokemonDAOimpl();
    }

    public Pokemon addPokemon(Pokemon pokemon) {
        return pokemonDAO.createPokemon(pokemon);
    }
    
}
