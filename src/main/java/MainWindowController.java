import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainWindowController {

    private String city;
    private String parameter;
    private String limit;
    private String path;

    private OpenAQPlatformAPI openAQPlatformAPI;
    private boolean isCityOk;
    private boolean isLengthOk;
    private boolean isLimitOk;
    private boolean isLimitDoubleOk;
    private boolean isOpen;

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
    private Button btnClear;

    @FXML
    private TextField textFieldCity;

    @FXML
    private TextField textFieldLimit;

    @FXML
    private TableView<?> tableAirQuality;

    @FXML
    private TextField textFieldNumber;

    @FXML
    private TextField textFieldLastDate;

    @FXML
    private TextField textFieldFirstDate;

    @FXML
    private TextField TextFieldSD;

    @FXML
    private TextField textFieldMax;

    @FXML
    private TextField textFieldMin;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnLoad;

    @FXML
    void btnCOClicked(ActionEvent event) {
        city = null;
        parameter = null;
        isCityOk = false;
        isLengthOk = false;
        isLimitOk = false;
        isLimitDoubleOk = false;

        try {
            city = textFieldCity.getText();
            if (city.isEmpty())
                throw new IllegalArgumentException();
             else
                isCityOk = true;
        }catch (IllegalArgumentException e ) {
            textFieldCity.setText("Please enter name of city");
        }

        try{
            limit = textFieldLimit.getText();
            if (limit.isEmpty() )
                throw new IllegalArgumentException();
            else
                isLimitOk = true;

            if(isLimitOk){
                double limitDouble = Double.parseDouble(limit);

                if (limitDouble<=0 || limitDouble>10000)
                    throw new IllegalArgumentException();
                else
                    isLimitDoubleOk = true;
            }
        }catch (IllegalArgumentException e){
            textFieldLimit.setText("Limit has to be between 1 and 10000");
        }

        if (isCityOk && isLimitOk && isLimitDoubleOk) {
            parameter = "co";
            try {
                openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0, 1).toUpperCase() + city.toLowerCase().substring(1), parameter,limit);
                if (openAQPlatformAPI.getResponse().length()<200)
                    throw new IllegalArgumentException();
                else
                    isLengthOk = true;
            }catch (StringIndexOutOfBoundsException e){
                textFieldCity.setText("Please enter the correct name of city");
            }catch (IllegalArgumentException e){
                textFieldCity.setText("Invalid name or unsupported city");
            }
        }

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk){
            openAQPlatformAPI.getParameter();
            openAQPlatformAPI.getCity();
            openAQPlatformAPI.getLimit();
        }

    }//end of btnCOClicked


    @FXML
    void btnNO2Clicked(ActionEvent event) {
        city = null;
        parameter = null;
        isCityOk = false;
        isLengthOk = false;

        try {
            city = textFieldCity.getText();
            if (city.isEmpty()) {
                throw new IllegalArgumentException();
            } else
                isCityOk = true;
        }catch (IllegalArgumentException e ) {
            textFieldCity.setText("Please enter name of city");
        }

        try{
            limit = textFieldLimit.getText();
            if (limit.isEmpty() )
                throw new IllegalArgumentException();
            else
                isLimitOk = true;

            if(isLimitOk){
                double limitDouble = Double.parseDouble(limit);

                if (limitDouble<=0 || limitDouble>10000)
                    throw new IllegalArgumentException();
                else
                    isLimitDoubleOk = true;
            }
        }catch (IllegalArgumentException e){
            textFieldLimit.setText("Limit has to be between 1 and 10000");
        }

        if (isCityOk && isLimitOk && isLimitDoubleOk) {
            parameter = "no2";
            try {
                openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0, 1).toUpperCase() + city.toLowerCase().substring(1), parameter,limit);
                if (openAQPlatformAPI.getResponse().length()<200)
                    throw new IllegalArgumentException();
                else
                    isLengthOk = true;
            }catch (StringIndexOutOfBoundsException e){
                textFieldCity.setText("Please enter the correct name of city");
            }catch (IllegalArgumentException e){
                textFieldCity.setText("Invalid name or unsupported city");
            }
        }

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk){
            openAQPlatformAPI.getParameter();
            openAQPlatformAPI.getCity();
            openAQPlatformAPI.getLimit();
        }
    }//end of btnNO2Clicked

    @FXML
    void btnO3clicked(ActionEvent event) {
        city = null;
        parameter = null;
        isCityOk = false;
        isLengthOk = false;

        try {
            city = textFieldCity.getText();
            if (city.isEmpty()) {
                throw new IllegalArgumentException();
            } else
                isCityOk = true;
        }catch (IllegalArgumentException e ) {
            textFieldCity.setText("Please enter name of city");
        }

        try{
            limit = textFieldLimit.getText();
            if (limit.isEmpty() )
                throw new IllegalArgumentException();
            else
                isLimitOk = true;

            if(isLimitOk){
                double limitDouble = Double.parseDouble(limit);

                if (limitDouble<=0 || limitDouble>10000)
                    throw new IllegalArgumentException();
                else
                    isLimitDoubleOk = true;
            }
        }catch (IllegalArgumentException e){
            textFieldLimit.setText("Limit has to be between 1 and 10000");
        }

        if (isCityOk && isLimitOk && isLimitDoubleOk) {
            parameter = "o3";
            try {
                openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0, 1).toUpperCase() + city.toLowerCase().substring(1), parameter,limit);
                if (openAQPlatformAPI.getResponse().length()<200)
                    throw new IllegalArgumentException();
                else
                    isLengthOk = true;
            }catch (StringIndexOutOfBoundsException e){
                textFieldCity.setText("Please enter the correct name of city");
            }catch (IllegalArgumentException e){
                textFieldCity.setText("Invalid name or unsupported city");
            }
        }

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk){
            openAQPlatformAPI.getParameter();
            openAQPlatformAPI.getCity();
            openAQPlatformAPI.getLimit();
        }
    }//end of btnO3clicked

    @FXML
    void btnPM10Clicked(ActionEvent event) {
        city = null;
        parameter = null;
        isCityOk = false;
        isLengthOk = false;

        try {
            city = textFieldCity.getText();
            if (city.isEmpty()) {
                throw new IllegalArgumentException();
            } else
                isCityOk = true;
        }catch (IllegalArgumentException e ) {
            textFieldCity.setText("Please enter name of city");
        }

        try{
            limit = textFieldLimit.getText();
            if (limit.isEmpty() )
                throw new IllegalArgumentException();
            else
                isLimitOk = true;

            if(isLimitOk){
                double limitDouble = Double.parseDouble(limit);

                if (limitDouble<=0 || limitDouble>10000)
                    throw new IllegalArgumentException();
                else
                    isLimitDoubleOk = true;
            }
        }catch (IllegalArgumentException e){
            textFieldLimit.setText("Limit has to be between 1 and 10000");
        }

        if (isCityOk && isLimitOk && isLimitDoubleOk) {
            parameter = "pm10";
            try {
                openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0, 1).toUpperCase() + city.toLowerCase().substring(1), parameter,limit);
                if (openAQPlatformAPI.getResponse().length()<200)
                    throw new IllegalArgumentException();
                else
                    isLengthOk = true;
            }catch (StringIndexOutOfBoundsException e){
                textFieldCity.setText("Please enter the correct name of city");
            }catch (IllegalArgumentException e){
                textFieldCity.setText("Invalid name or unsupported city");
            }
        }

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk){
            openAQPlatformAPI.getParameter();
            openAQPlatformAPI.getCity();
            openAQPlatformAPI.getLimit();
        }
    }//end of btnPM10Clicked

    @FXML
    void btnPM25Clicked(ActionEvent event) {
        city = null;
        parameter = null;
        isCityOk = false;
        isLengthOk = false;

        try {
            city = textFieldCity.getText();
            if (city.isEmpty()) {
                throw new IllegalArgumentException();
            } else
                isCityOk = true;
        }catch (IllegalArgumentException e ) {
            textFieldCity.setText("Please enter name of city");
        }

        try{
            limit = textFieldLimit.getText();
            if (limit.isEmpty() )
                throw new IllegalArgumentException();
            else
                isLimitOk = true;

            if(isLimitOk){
                double limitDouble = Double.parseDouble(limit);

                if (limitDouble<=0 || limitDouble>10000)
                    throw new IllegalArgumentException();
                else
                    isLimitDoubleOk = true;
            }
        }catch (IllegalArgumentException e){
            textFieldLimit.setText("Limit has to be between 1 and 10000");
        }

        if (isCityOk && isLimitOk && isLimitDoubleOk) {
            parameter = "pm25";
            try {
                openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0, 1).toUpperCase() + city.toLowerCase().substring(1), parameter,limit);
                if (openAQPlatformAPI.getResponse().length()<200)
                    throw new IllegalArgumentException();
                else
                    isLengthOk = true;
            }catch (StringIndexOutOfBoundsException e){
                textFieldCity.setText("Please enter the correct name of city");
            }catch (IllegalArgumentException e){
                textFieldCity.setText("Invalid name or unsupported city");
            }
        }

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk){
            openAQPlatformAPI.getParameter();
            openAQPlatformAPI.getCity();
            openAQPlatformAPI.getLimit();
        }
    }//end of btnPM25Clicked

    @FXML
    void btnSO2Clicked(ActionEvent event) {
        city = null;
        parameter = null;
        isCityOk = false;
        isLengthOk = false;

        try {
            city = textFieldCity.getText();
            if (city.isEmpty()) {
                throw new IllegalArgumentException();
            } else
                isCityOk = true;
        }catch (IllegalArgumentException e ) {
            textFieldCity.setText("Please enter name of city");
        }

        try{
            limit = textFieldLimit.getText();
            if (limit.isEmpty() )
                throw new IllegalArgumentException();
            else
                isLimitOk = true;

            if(isLimitOk){
                double limitDouble = Double.parseDouble(limit);

                if (limitDouble<=0 || limitDouble>10000)
                    throw new IllegalArgumentException();
                else
                    isLimitDoubleOk = true;
            }
        }catch (IllegalArgumentException e){
            textFieldLimit.setText("Limit has to be between 1 and 10000");
        }

        if (isCityOk && isLimitOk && isLimitDoubleOk) {
            parameter = "so2";
            try {
                openAQPlatformAPI = new OpenAQPlatformAPI(city.substring(0, 1).toUpperCase() + city.toLowerCase().substring(1), parameter,limit);
                if (openAQPlatformAPI.getResponse().length()<200)
                    throw new IllegalArgumentException();
                else
                    isLengthOk = true;
            }catch (StringIndexOutOfBoundsException e){
                textFieldCity.setText("Please enter the correct name of city");
            }catch (IllegalArgumentException e){
                textFieldCity.setText("Invalid name or unsupported city");
            }
        }

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk){
            addResults();
//            textFieldFirstDate.setText(openAQPlatformAPI.getDates().get(0).toString());
//            openAQPlatformAPI.getParameter();
//            openAQPlatformAPI.getCity();
//            openAQPlatformAPI.getLimit();
        }
    }//end of btnSO2Clicked

    @FXML
    void btnLoadClicked(ActionEvent event) {

    }

    @FXML
    void btnSaveClicked(ActionEvent event) {
        if (!isOpen) {
            openChoosePathWindow();
        }

        try {
            File file = new File(path);
            PrintWriter printWriter = new PrintWriter(file);

            printWriter.println(openAQPlatformAPI.getResponse());
            printWriter.close();

        } catch (FileNotFoundException e) {
            if (isOpen == false)
                openIncorrectPathWindow();
        } catch (NullPointerException e) {
            if (isOpen == false)
                openIncorrectPathWindow();
        }

    }

    @FXML
    void tableAirQualitySorted(ActionEvent event) {

    }

    @FXML
    void btnClearClicked(ActionEvent event) {
        textFieldLimit.clear();
        textFieldCity.clear();
        textFieldFirstDate.clear();
        textFieldLastDate.clear();
        textFieldMax.clear();
        textFieldMin.clear();
        textFieldNumber.clear();
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
        assert textFieldLimit != null : "fx:id=\"textFieldLimit\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert tableAirQuality != null : "fx:id=\"tableAirQuality\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textFieldNumber != null : "fx:id=\"textFieldNumber\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textFieldLastDate != null : "fx:id=\"textFieldLastDate\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textFieldFirstDate != null : "fx:id=\"textFieldFirstDate\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert TextFieldSD != null : "fx:id=\"TextFieldSD\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textFieldMax != null : "fx:id=\"textFieldMax\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textFieldMin != null : "fx:id=\"textFieldMin\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnLoad != null : "fx:id=\"btnLoad\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'MainWindow.fxml'.";

    }

    private void openChoosePathWindow() {
        try {
            isOpen = true;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/ChoosePathWindow.fxml"));
            Parent root = fxmlLoader.load();

            ChoosePathWindowController choosePathController = fxmlLoader.getController();
            Scene scene = new Scene(root);
           // scene.getStylesheets().add("/fxml/StylesheetChoosePathWindow.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Choose path to save trajectory");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();

            isOpen = false;
            path = choosePathController.getPath();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of openChoosePathWindow

    private void openIncorrectPathWindow() {
        try {
            isOpen = true;
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/IncorrectPathWindow.fxml"));
            Parent root = fxmlLoader.load();

            Scene scene = new Scene(root);
           // scene.getStylesheets().add("/fxml/StylesheetIncorrectPathWindow.css");
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Incorrect path");
            stage.initModality(Modality.WINDOW_MODAL);
            stage.showAndWait();
            isOpen = false;

        } catch (IOException e) {
            e.printStackTrace();
        }
    }//end of openIncorrectPathWindow

    public void addResults(){
        double size;
        String sizeString;
        ArrayList<Double> temp = openAQPlatformAPI.getValues();
        size = openAQPlatformAPI.getValues().size();
        sizeString = String.valueOf((int)size);

        Double min = temp.get(0);
        Double max = temp.get(0);

        for (int i = 0; i<size; i++){
            if (temp.get(i) <min)
                min = temp.get(i);
        }

        for (int i = 0; i<size; i++){
            if (temp.get(i) >max)
                max = temp.get(i);
        }


        System.out.println(min);
        textFieldMin.setText(min.toString());
        textFieldMax.setText(max.toString());
        textFieldNumber.setText(sizeString);
        textFieldFirstDate.setText(openAQPlatformAPI.getDates().get(0).toString());
        textFieldLastDate.setText(openAQPlatformAPI.getDates().get((int)size-1).toString());
    }//end of addResults

}//end of class

