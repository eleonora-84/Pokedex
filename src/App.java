import model.Pokemon;
import persistance.DatabaseManager;
import persistance.util.DatabaseConnector;

public class App {
    public static void main(String[] args) throws Exception {
        DatabaseConnector.getConnection();
        
        PokemonDatabase pokemonDB = new PokemonDatabase();
        
        Pokemon p1 = new Pokemon("Pikachu", "electricity", 20);
        Pokemon p2 = new Pokemon("Bulbasaur", "grass", 18);
        Pokemon p3 = new Pokemon("Charmender", "fire", 15);
        Pokemon p4 = new Pokemon("Squirtle", "water", 25);
        
        // pokemonDB.createPokemon(p1);
        // pokemonDB.createPokemon(p2);
        // pokemonDB.createPokemon(p3);
        // pokemonDB.createPokemon(p4);

        // pokemonDB.getPokemonByID(3);
        System.out.println(pokemonDB.getAllPokemon());
    
     
    }
}
