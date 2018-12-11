package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CharacterEntity {

  private IntegerProperty playerID;
  private StringProperty characterName;
  private StringProperty className;


  public IntegerProperty idProperty() {
    if (playerID == null) {
      playerID = new SimpleIntegerProperty(this, "ID");
    }
    return playerID;
  }
  public void setPlayerID(int value) {
    idProperty().set(value);
  }
  public int getPlayerID(){
    return playerID.get();
  }



  public StringProperty characterNameProperty() {
    if (characterName == null) {
      characterName = new SimpleStringProperty(this, "name");

    }
    return characterName;
  }
  public void setCharacterName(String value) {
    characterNameProperty().set(value);
  }
  public String getCharacterName(){
    return characterName.get();
  }


  public CharacterEntity() {
    this.playerID = new SimpleIntegerProperty();
    this.characterName = new SimpleStringProperty();
    this.className = new SimpleStringProperty();
    setPlayerID(1);
  }


  public StringProperty classProperty() {
    if (className == null) {
      className = new SimpleStringProperty(this, "ckass");

    }
    return className;
  }
  public void setCharClass(String value) {
    classProperty().set(value);
  }
  public String getClassName(){
    return className.get();
  }

}
