package sample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.CharacterEntity;
import model.CharacterEntityDAO;

public class Main extends Application {


  // database URL, username and password
  private static final String DATABASE_URL = "jdbc:derby:C:\\Users\\dpbailey4801\\Downloads\\Project-master\\CharactersDBfx\\lib\\Characters";
  private static final String USERNAME = "admin";
  private static final String PASSWORD = "password";


  // default query retrieves all data from characters table
  private static final String DEFAULT_QUERY = "SELECT * FROM Characters ORDER BY playerID";


  public LinkedList<CharacterEntity> characters = new LinkedList<>();


  @Override
  public void start(Stage primaryStage) throws Exception {


    // populateData();

    TableView<CharacterEntity> characterList = new TableView<>();

    characterList.setItems(CharacterEntityDAO.searchCharacterEntities());

    //ComboBox<CharacterEntity> convertListTypes = new ComboBox<CharacterEntity>(oList);
//    characterList.setItems(oList);

    Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("CharacterDB.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 700, 575));
    primaryStage.show();

  }

  //-----------


  //------------
/*

this is all just a lot of test code


  public ObservableList<CharacterEntity> populateData() {

    // characters = FXCollections.observableArrayList();
    TableView<CharacterEntity> characterList = new TableView<>();

    CharacterEntity rowNum = new CharacterEntity();
    rowNum.setPlayerID(0);
    ObservableList<CharacterEntity> observableList = FXCollections.observableArrayList(rowNum);

    //characterList.setItems(observableList);
    try {

      Connection characterDB = DriverManager.getConnection(DATABASE_URL, "admin", "password");
      String sortTable = "SELECT * FROM Characters ORDER BY playerID";
      ResultSet characterColumn = characterDB.createStatement().executeQuery(sortTable);

      int i = 1;

      while (characterColumn.next()) {

        int ID = characterColumn.getInt(1);
        String Name = characterColumn.getString(2);
        String charC = characterColumn.getString(3);
        System.out.println(ID);
       rowNum.setPlayerID(ID);

        rowNum.setCharacterName(Name);

        rowNum.setCharClass(charC);
       observableList.set(i, rowNum);
        i++;

      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Couldn't populate from database");
    }

    return observableList;
  }
*/
  public static void main(String[] args) {

    launch(args);
  }
}
