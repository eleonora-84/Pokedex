import model.Pokemon;
import persistance.DatabaseManager;
import persistance.util.DatabaseConnector;

public class App {
    public static void main(String[] args) throws Exception {
        DatabaseConnector.getConnection();
        
        PokemonDatabase pokemonDB = new PokemonDatabase();
        
        Pokemon p1 = new Pokemon("Pikachu", "electricity", 20);
        
        pokemonDB.addPokemon(p1);
     
    }
}
