package sample;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
public class Controller  extends Main implements Initializable {

@FXML
  public TableView<dataType> CHARTABLE;
  @FXML
  public TableColumn<dataType, Integer> playerID;
  @FXML
  private TableColumn<dataType, String> charName;
  @FXML
  private TableColumn<dataType, String> charClass;

  @FXML
  public void initialize(URL location, ResourceBundle resources) {

    TableColumn<dataType, Integer> playerID = new TableColumn<>("ID");
    playerID.setMinWidth(80);
    playerID.setCellValueFactory(new PropertyValueFactory<>("ID"));
    TableColumn<dataType, String> charName = new TableColumn<>("Character Name");
    charName.setMinWidth(80);
    charName.setCellValueFactory(new PropertyValueFactory<>("Name"));
    TableColumn<dataType, Integer> charClass = new TableColumn<>("Class");
    charClass.setMinWidth(80);
    charClass.setCellValueFactory(new PropertyValueFactory<>("Class"));
//    CHARTABLE.getColumns().addAll(playerID,charName,charClass);
  }
}
