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

public class Main extends Application {


  // database URL, username and password
  private static final String DATABASE_URL = "jdbc:derby:C:\\Users\\Dan\\Documents\\school\\OraclProduction\\CharactersDBfx\\lib\\Characters";
  private static final String USERNAME = "admin";
  private static final String PASSWORD = "password";


  // default query retrieves all data from authors table
  private static final String DEFAULT_QUERY = "SELECT * FROM Characters ORDER BY playerID";


  public LinkedList<dataType> characters = new LinkedList<>();



  @Override
  public void start(Stage primaryStage) throws Exception {
    TableColumn<dataType, Integer> playerID = new TableColumn<>("ID");
    playerID.setMinWidth(80);
    playerID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    TableColumn<dataType, String> charName = new TableColumn<>("Character Name");
    charName.setMinWidth(80);
    charName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    TableColumn<dataType, Integer> charClass = new TableColumn<>("Class");
    charClass.setMinWidth(80);
    charClass.setCellValueFactory(new PropertyValueFactory<>("Class"));


   // populateData();

    TableView<dataType> characterList = new TableView<>();

   characterList.setItems(populateData());

    //ComboBox<dataType> convertListTypes = new ComboBox<dataType>(oList);
//    characterList.setItems(oList);
    //characterList.set
    Parent root = FXMLLoader.load(getClass().getResource("CharacterDB.fxml"));
    primaryStage.setTitle("Hello World");
    primaryStage.setScene(new Scene(root, 700, 575));
    primaryStage.show();

  }

  //-----------
  public class dataType {

    private IntegerProperty playerID;

    public void setPlayerID(int value) {
      idProperty().set(value);
    }

    public IntegerProperty idProperty() {
      if (playerID == null) {
        playerID = new SimpleIntegerProperty(this, "ID");
      }
      return playerID;
    }

    private StringProperty characterName;

    public void setCharacterName(String value) {
      characterNameProperty().set(value);
    }

    public StringProperty characterNameProperty() {
      if (characterName == null) {
        characterName = new SimpleStringProperty(this, "name");

      }
      return characterName;
    }
    public dataType(){
      setPlayerID(1);
    }
    private StringProperty className;

    public void setClass(String value) {
      classProperty().set(value);
    }

    public StringProperty classProperty() {
      if (className == null) {
        className = new SimpleStringProperty(this, "ckass");

      }
      return className;
    }

  }

  //------------

  public ObservableList populateData() throws SQLException {

    // characters = FXCollections.observableArrayList();
    TableView<dataType> characterList = new TableView<>();
    ObservableList<dataType> observableList = FXCollections.observableArrayList();

dataType rowNum = new dataType();
    rowNum.setPlayerID(1);
    characterList.setItems(observableList);
    try {

      Connection characterDB = DriverManager.getConnection(DATABASE_URL, "admin", "password");

      String sortTable = "SELECT * FROM Characters ORDER BY playerID";
      ResultSet characterColumn = characterDB.createStatement().executeQuery(sortTable);
      int i = 1;

      while (characterColumn.next()) {


        int ID = characterColumn.getInt(1);
        String Name = characterColumn.getString(2);
        String charC = characterColumn.getString(3);


        rowNum.setPlayerID(ID);

        rowNum.setCharacterName(Name);

        rowNum.setClass(charC);
        observableList.set(i,rowNum );
        i++;
      }

    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Couldn't populate from database");
    }


    return observableList;
  }

  public static void main(String[] args) {

    launch(args);
  }
}
