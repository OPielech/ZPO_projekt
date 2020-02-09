import javafx.scene.chart.XYChart;

import java.util.ArrayList;

public class ScatterChartData {
    private String city;
    private String parameter;
    private String limit;
    private OpenAQPlatformAPI openAQPlatformAPI;

    public ScatterChartData(String city, String parameter, String limit) {
        this.city = city;
        this.parameter = parameter;
        this.limit = limit;
    }




    public XYChart.Series getValues(){
        openAQPlatformAPI = new OpenAQPlatformAPI(city,parameter,limit);
        XYChart.Series series = new XYChart.Series();
        ArrayList temp = openAQPlatformAPI.getValues();
        int size = temp.size();

        for (int i=0; i<size; i++){
            series.getData().add(new XYChart.Data(i,temp.get(i)));
        }

        return series;
    }//end of getValues

    public XYChart.Series getNormValues(){
        openAQPlatformAPI = new OpenAQPlatformAPI(city,parameter,limit);
        XYChart.Series series = new XYChart.Series();
        ArrayList temp = openAQPlatformAPI.getValues();
        int size = temp.size();

        if (openAQPlatformAPI.getParameter().equals("pm10")) {
            for (int i = 0; i < size; i++)
                series.getData().add(new XYChart.Data(i, 50));
        }

        else if (openAQPlatformAPI.getParameter().equals("pm25")){
            for (int i = 0; i < size; i++)
                series.getData().add(new XYChart.Data(i, 25));
        }

        else if (openAQPlatformAPI.getParameter().equals("no2")){
            for (int i = 0; i < size; i++)
                series.getData().add(new XYChart.Data(i, 200));
        }

        else if (openAQPlatformAPI.getParameter().equals("so2")){
            for (int i = 0; i < size; i++)
                series.getData().add(new XYChart.Data(i, 350));
        }

        else if (openAQPlatformAPI.getParameter().equals("co")){
            for (int i = 0; i < size; i++)
                series.getData().add(new XYChart.Data(i, 10000));
        }

        else{
            for (int i = 0; i < size; i++)
                series.getData().add(new XYChart.Data(i, 150));
        }

        return series;
    }

}//end of class
