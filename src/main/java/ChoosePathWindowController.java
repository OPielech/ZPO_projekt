import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ChoosePathWindowController {

    private String path;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField labelChoosePath;

    @FXML
    private Button buttonApply;

    @FXML
    void buttonApplyPressed(ActionEvent event) {
        path = labelChoosePath.getText().replaceAll("\"", "");

        Stage stage = (Stage) buttonApply.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert labelChoosePath != null : "fx:id=\"labelChoosePath\" was not injected: check your FXML file 'ChoosePathWindow.fxml'.";
        assert buttonApply != null : "fx:id=\"buttonApply\" was not injected: check your FXML file 'ChoosePathWindow.fxml'.";

    }

    public String getPath() {
        return path;
    }
}//end of class
