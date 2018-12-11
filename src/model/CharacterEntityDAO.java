package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import util.DBUtil;

public class CharacterEntityDAO {

  public static CharacterEntity searchCharacterEntity(String charName)
      throws SQLException, ClassNotFoundException {
    CharacterEntity characterEntity;


      //Declare a SELECT statement
      String selectStmt = "SELECT * FROM Characters WHERE charName = '" + charName +"'";

      //Execute SELECT statement
      try {
        //Get ResultSet from dbExecuteQuery method
        ResultSet rsCharacterEntity = DBUtil.dbExecuteQuery(selectStmt);

        //Send ResultSet to the getAuthorFromResultSet method and get author object
        characterEntity = getCharacterEntityFromResultSet(rsCharacterEntity);

        //Return employee object
        return characterEntity;
      } catch (SQLException e) {
        System.out
            .println("While searching a player with name : " + charName + ", an error occurred: " + e);
        //Return exception
        throw e;
      }
    }
  //Use ResultSet from DB as parameter and set CharacterEntity Object's attributes and return author object.
  private static CharacterEntity getCharacterEntityFromResultSet(ResultSet rs) throws SQLException {
    CharacterEntity characterEntity = null;
    if (rs.next()) {
      characterEntity = new CharacterEntity();
      characterEntity.setPlayerID(rs.getInt("playerID"));
      characterEntity.setCharacterName(rs.getString("charName"));
      characterEntity.setCharClass(rs.getString("Class"));
    }
    return characterEntity;
  }
  //*******************************
  //SELECT Characters
  //*******************************
  public static ObservableList<CharacterEntity> searchCharacterEntities() throws SQLException, ClassNotFoundException {
    //Declare a SELECT statement
    String selectStmt = "SELECT * FROM Characters";

    //Execute SELECT statement
    try {
      //Get ResultSet from dbExecuteQuery method
      ResultSet rsAuth = DBUtil.dbExecuteQuery(selectStmt);

      //Send ResultSet to the getEmployeeList method and get employee object
      ObservableList<CharacterEntity> characterList = getCharacterEntityList(rsAuth);
//--------
      //Return employee object
      return characterList;
    } catch (SQLException e) {
      System.out.println("SQL select operation has been failed: " + e);
      //Return exception
      throw e;
    }
  }
  //returns the list of characters
  public static ObservableList<CharacterEntity> getCharacterEntityList(ResultSet rs)
      throws SQLException, ClassNotFoundException {
    //Declare a observable List which comprises of Employee objects
    ObservableList<CharacterEntity> characterList = FXCollections.observableArrayList();

    while (rs.next()) {
      CharacterEntity characterEntity = new CharacterEntity();
      characterEntity.setPlayerID(rs.getInt("playerID"));
      characterEntity.setCharacterName(rs.getString("charName"));
      characterEntity.setCharClass(rs.getString("Class"));


      characterList.add(characterEntity);
    }

    return characterList;
  }
  //*************************************
  //DELETE a character
  // OR DELETE all characters of a player with a certain ID
  //*************************************
  public static void deleteCharacterEntityWithName(String charName) throws SQLException, ClassNotFoundException {
    //Declare a DELETE statement
    String updateStmt =
        "DELETE FROM Characters " +
            "WHERE charName = '" + charName + "' OR playerID = " + charName;

    //Execute DELETE operation
    try {
      DBUtil.dbExecuteUpdate(updateStmt);
    } catch (SQLException e) {
      System.out.print("Error occurred while DELETE Operation: " + e);
      throw e;
    }
  }
  //*************************************
  //INSERT a generic character; the multiple fields for a character entity
  // mean that entering in your own data is a hassle. this is basically to demonstrate
  // the delete function.
  //*************************************
  public static void insertCharacter()
      throws SQLException, ClassNotFoundException {
    //Declare a DELETE statement
    String updateStmt =
        "INSERT INTO Characters " +
            "(playerID, charName, Class) " +
            "VALUES " +
            "(" + 1 + ", '" + "genericName" + "', '" + "Mage" + "')";

    //Execute INSERT operation
    try {
      DBUtil.dbExecuteUpdate(updateStmt);
    } catch (SQLException e) {
      System.out.print("Error occurred while INSERT Operation: " + e);
      throw e;
    }

  }


}


