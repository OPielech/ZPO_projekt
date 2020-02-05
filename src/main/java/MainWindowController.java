import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class MainWindowController {

    private String city;
    private String parameter;

    private OpenAQPlatformAPI openAQPlatformAPI;
    private boolean isCityOk = false;

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

//        try {
//            isDistanceNotNull = false;
//            distance = null;
//            distance = Double.valueOf(labelDistance.getText());
//            if (distance.equals(null))
//                throw new IllegalArgumentException();
//            else
//                isDistanceNotNull = true;
//        } catch (IllegalArgumentException e) {
//            labelDistance.setText("Please insert a distance");
//        }

        try {
            isCityOk = false;
            city = null;
            city = textFieldCity.getText();
            if (city==null) {
                throw new IllegalArgumentException();
            } else
                isCityOk = true;
        }catch (IllegalArgumentException e ) {
            e.printStackTrace();
            textFieldCity.setText("Please enter the correct name of city");
        }

        if (isCityOk) {
            parameter = "co";
            try {
                openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0, 1).toUpperCase() + city.toLowerCase().substring(1), parameter);
            }catch (StringIndexOutOfBoundsException e){
                textFieldCity.setText("Please enter the correct name of city");
            }
        }

        openAQPlatformAPI.getCity();
        openAQPlatformAPI.getParameter();
        openAQPlatformAPI.getResponse();
    }

    @FXML
    void btnNO2Clicked(ActionEvent event) {

        city = textFieldCity.getText();
        parameter = "no2";
        openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0,1).toUpperCase()+city.toLowerCase().substring(1), parameter);
        openAQPlatformAPI.getCity();
        openAQPlatformAPI.getParameter();
    }

    @FXML
    void btnO3clicked(ActionEvent event) {
        city = textFieldCity.getText();
        parameter = "o3";
        openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0,1).toUpperCase()+city.toLowerCase().substring(1), parameter);
        openAQPlatformAPI.getCity();
        openAQPlatformAPI.getParameter();
    }

    @FXML
    void btnPM10Clicked(ActionEvent event) {
        city = textFieldCity.getText();
        parameter = "pm10";
        openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0,1).toUpperCase()+city.toLowerCase().substring(1), parameter);
        openAQPlatformAPI.getCity();
        openAQPlatformAPI.getParameter();
    }

    @FXML
    void btnPM25Clicked(ActionEvent event) {
        city = textFieldCity.getText();
        parameter = "pm25";
        openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0,1).toUpperCase()+city.toLowerCase().substring(1), parameter);
        openAQPlatformAPI.getCity();
        openAQPlatformAPI.getParameter();
    }

    @FXML
    void btnSO2Clicked(ActionEvent event) {
        city = textFieldCity.getText();
        parameter = "so2";
        openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0,1).toUpperCase()+city.toLowerCase().substring(1), parameter);
        openAQPlatformAPI.getCity();
        openAQPlatformAPI.getParameter();
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
