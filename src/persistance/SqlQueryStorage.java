package persistance;

public class SqlQueryStorage {

  //DDL
  public static final String createPokemonTable =
    "CREATE TABLE IF NOT EXISTS `Pokedex`.`Pokemon` (`id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(45) NOT NULL, `elementType` VARCHAR(45) NULL, `level` INT NULL, PRIMARY KEY (`id`));";

  //DML
  public static final String insertPokemon = "INSERT INTO `Pokedex`.`Pokemon` (`name`, `elementType`, `level`) VALUES (?, ?, ?);";
  public static final String getPokemonByID = "SELECT * FROM `Pokedex`.`Pokemon` WHERE id = ?";
  public static final String getAllPokemon = "SELECT * FROM `Pokedex`.`Pokemon`";
  public static final String updatePokemon = "UPDATE `Pokedex`.`Pokemon` SET `name` = ?, `elementType` = ?, `level` = ? WHERE (`id` = ?)";
  public static final String deletePokemonByID = "DELETE FROM `Pokedex`.`Pokemon` WHERE id = ?";
}
