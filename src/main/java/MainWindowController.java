import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnPM10;

    @FXML
    private Button btnPM25;

    @FXML
    private Button btnO3;

    @FXML
    private Button btnNO2;

    @FXML
    private Button btnSO2;

    @FXML
    private Button btnCO;

    @FXML
    private TextField textFieldCity;

    @FXML
    void btnCOClicked(ActionEvent event) {

    }

    @FXML
    void btnNO2Clicked(ActionEvent event) {

    }

    @FXML
    void btnO3clicked(ActionEvent event) {

    }

    @FXML
    void btnPM10Clicked(ActionEvent event) {

    }

    @FXML
    void btnPM25Clicked(ActionEvent event) {

    }

    @FXML
    void btnSO2Clicked(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert btnPM10 != null : "fx:id=\"btnPM10\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnPM25 != null : "fx:id=\"btnPM25\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnO3 != null : "fx:id=\"btnO3\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnNO2 != null : "fx:id=\"btnNO2\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnSO2 != null : "fx:id=\"btnSO2\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnCO != null : "fx:id=\"btnCO\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textFieldCity != null : "fx:id=\"textFieldCity\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }
}
