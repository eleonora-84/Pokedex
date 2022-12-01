package model;

public class Pokemon {

  private int id;
  private String name;
  private String elementType;
  private int level;

  public Pokemon(int id, String name, String elementType, int level) {
    this.id = id;
    this.name = name;
    this.elementType = elementType;
    this.level = level;
  }

  public Pokemon() {}

  public Pokemon(String name, String elementType, int level) {
    this.name = name;
    this.elementType = elementType;
    this.level = level;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getElementType() {
    return elementType;
  }

  public void setElementType(String elementType) {
    this.elementType = elementType;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }
}
