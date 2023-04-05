import model.Pokemon;

public class App {
    public static void main(String[] args) throws Exception {
        
        PokemonDatabase pokemonDB = new PokemonDatabase();
        
        Pokemon p1 = new Pokemon("Pikachu", "electricity", 20);
        Pokemon p2 = new Pokemon("Bulbasaur", "grass", 18);
        Pokemon p3 = new Pokemon("Charmender", "fire", 15);
        Pokemon p4 = new Pokemon("Squirtle", "water", 25);
        
        pokemonDB.createPokemon(p1);
        pokemonDB.createPokemon(p2);
        pokemonDB.createPokemon(p3);
        pokemonDB.createPokemon(p4);
        
        // pokemonDB.getPokemonByID(3);
        
        
        System.out.println(pokemonDB.getAllPokemon());
       

        p3.setId(3); // per matchare con database (se no non lo trova)
        p3.setName("Pikachu");
        p3.setElementType("electricity");
        p3.setLevel(30);
        
        pokemonDB.updatePokemon(p3);
        System.out.println(pokemonDB.getAllPokemon());
        System.out.println("*****");

        pokemonDB.deletePokemonByID(3);
        System.out.println(pokemonDB.getAllPokemon());
        
        pokemonDB.closeConnection();
        
        
        // System.out.println(pokemonDB.getAllPokemon());
        /*
        ConvertPokemon.convertFromList2Array();
        ConvertPokemon.multiplyDivideID();
     */
    }
}
