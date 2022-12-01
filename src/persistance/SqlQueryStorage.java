package persistance;

public class SqlQueryStorage {
    //DDL
    public static final String createPokemonTable = "CREATE TABLE IF NOT EXISTS `Pokedex`.`Pokemon` (`id` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(45) NOT NULL, `elementType` VARCHAR(45) NULL, `level` INT NULL, PRIMARY KEY (`id`));";
    
}
