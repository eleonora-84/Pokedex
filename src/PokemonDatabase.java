import java.util.ArrayList;
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

  public Pokemon createPokemon(Pokemon pokemon) {
    return pokemonDAO.createPokemon(pokemon);
  }

  public void getPokemonByID(int id) {
    pokemonDAO.getPokemonByID(id);
  }

  public ArrayList<Pokemon> getAllPokemon() {
    return pokemonDAO.getAllPokemon();
  }

  public Pokemon updatePokemon(Pokemon pokemon) {
    return pokemonDAO.updatePokemon(pokemon);
  }

  public void deletePokemonByID(int id) {
    pokemonDAO.deletePokemonByID(id);
  }

  public void closeConnection() {
    pokemonDAO.closeConnection();
  }
}
