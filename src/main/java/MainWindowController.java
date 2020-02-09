import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.ScatterChart;
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
    private TextField textField1;

    @FXML
    private TextField textField2;

    @FXML
    private TextField textField3;

    @FXML
    private TextField textField4;

    @FXML
    private TextField textField5;

    @FXML
    private TextField textField6;

    @FXML
    private TextField textField7;

    @FXML
    private TextField textField8;

    @FXML
    private TextField textField9;

    @FXML
    private TextField textField10;

    @FXML
    private TextField textField11;

    @FXML
    private TextField textField12;

    @FXML
    private TextField textField13;

    @FXML
    private TextField textField14;

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
    private TextField textFieldSD;

    @FXML
    private TextField textFieldMax;

    @FXML
    private TextField textFieldMin;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnLoad;

    @FXML
    private ScatterChart<Number, Number> scatterChart;



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

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk)
            addResults();

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

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk)
            addResults();

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
            if (limit.isEmpty())
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

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk)
            addResults();

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

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk) {
            addResults();
            addToTable();
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

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk)
            addResults();

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

        if (isLengthOk && isCityOk && isLimitOk && isLimitDoubleOk)
            addResults();

    }//end of btnSO2Clicked

    @FXML
    void btnLoadClicked(ActionEvent event) {
        isCityOk = false;
        isLimitOk = false;
        try {
            if(!openAQPlatformAPI.getCity().isEmpty())
                isCityOk = true;
            else
                throw new NullPointerException();

            if(!openAQPlatformAPI.getLimit().isEmpty())
                isLimitOk = true;
            else
                throw new NullPointerException();

            if(openAQPlatformAPI.getCity().isEmpty() && textFieldCity.getText().isEmpty())
                isCityOk = true;
            else
                throw new NullPointerException();

            if(openAQPlatformAPI.getLimit().isEmpty() && textFieldLimit.getText().isEmpty())
                isLimitOk = true;
            else
                throw new NullPointerException();

        }catch (NullPointerException e){
            if (!isCityOk && isLimitOk)
                textFieldCity.setText("Please enter the name of city");
            else if (!isLimitOk && isCityOk)
                textFieldLimit.setText("Please enter the limit");
            else{
                textFieldCity.setText("Please enter the name of city");
                textFieldLimit.setText("Please enter the limit");
            }
        }

        if(isLimitOk && isCityOk) {
            addResults();
            textFieldCity.setText(openAQPlatformAPI.getCity());
            textFieldLimit.setText(openAQPlatformAPI.getLimit());
        }
    }//end of btnLoadClicked

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
        textFieldSD.clear();
        scatterChart.getData().clear();
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
        assert textFieldSD != null : "fx:id=\"textFieldSD\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textFieldMax != null : "fx:id=\"textFieldMax\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textFieldMin != null : "fx:id=\"textFieldMin\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnSave != null : "fx:id=\"btnSave\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnLoad != null : "fx:id=\"btnLoad\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert scatterChart != null : "fx:id=\"scatterChart\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField1 != null : "fx:id=\"textField1\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField2 != null : "fx:id=\"textField2\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField3 != null : "fx:id=\"textField3\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField4 != null : "fx:id=\"textField4\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField5 != null : "fx:id=\"textField5\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField6 != null : "fx:id=\"textField6\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField7 != null : "fx:id=\"textField7\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField8 != null : "fx:id=\"textField8\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField9 != null : "fx:id=\"textField9\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField10 != null : "fx:id=\"textField10\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField11 != null : "fx:id=\"textField11\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField12 != null : "fx:id=\"textField12\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField13 != null : "fx:id=\"textField13\" was not injected: check your FXML file 'MainWindow.fxml'.";
        assert textField14 != null : "fx:id=\"textField14\" was not injected: check your FXML file 'MainWindow.fxml'.";


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
        double sum = 0;
        double average;
        double size;
        double standardDeviation = 0;
        String sizeString;
        scatterChart.getData().clear();

        ScatterChartData scatterChartData = new ScatterChartData
                (openAQPlatformAPI.getCity(),openAQPlatformAPI.getParameter(),openAQPlatformAPI.getLimit());

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

        for (int i=0; i<size; i++)
            sum+=temp.get(i);


        average = sum/size;
        sum = 0;

        for (int i =0; i<size; i++)
           sum+= Math.pow(temp.get(i)-average,2);

        standardDeviation = Math.sqrt(sum/size);

        textFieldMin.setText(String.format("%.5f",min));
        textFieldMax.setText(String.format("%.5f",max));
        textFieldSD.setText(String.format("%.5f",standardDeviation));
        textFieldNumber.setText(sizeString);
        textFieldFirstDate.setText(openAQPlatformAPI.getDates().get(0).toString());
        textFieldLastDate.setText(openAQPlatformAPI.getDates().get((int)size-1).toString());
        scatterChart.getData().add(scatterChartData.getNormValues());
        scatterChart.getData().add(scatterChartData.getValues());
    }//end of addResults

    public void addToTable(){
        String firstIndex = textField1.getText();
        String secondIndex = textField2.getText();
        String thirdIndex = textField3.getText();
        String fourthIndex = textField4.getText();
        String fifthIndex = textField5.getText();
        String sixthIndex = textField6.getText();
        String seventhIndex = textField7.getText();
        if (parameter.equals("pm10")){
            textField1.setText(fifthIndex+" 0 - 20");
            textField2.setText(secondIndex+" 20,1 - 50");
            textField3.setText(thirdIndex+" 50,1 - 80");
            textField4.setText(fourthIndex+" 80,1 - 110");
            textField5.setText(fifthIndex+" 110,1 - 150");
            textField6.setText(sixthIndex+" >150");

        }

    }//end of addToTable

}//end of class

