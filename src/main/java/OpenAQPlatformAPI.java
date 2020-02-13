
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class OpenAQPlatformAPI {
    private String city;
    private String parameter;
    private String limit;
    Gson gson = new Gson();

    public OpenAQPlatformAPI(String city, String parameter, String limit) {
        this.city = city;
        this.parameter = parameter;
        this.limit = limit;
    }

    public String getCity() {
        return city;
    }

    public String getParameter() {
        return parameter;
    }

    public String getLimit() {
        return limit;
    }

    public String getResponse() {

        String response1 = null;
        StringBuffer response = new StringBuffer();
        String url = "https://api.openaq.org/v1/measurements?city=" + city + "&parameter=" + parameter + "&limit=" + limit;

        try {
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();

            String inputLine;
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            response1 = response.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return response1;
    }//end of getResponse

    public ArrayList getDates() {
        MappingJSON mappingJSON = gson.fromJson(getResponse(), MappingJSON.class);
        List<Results> list = mappingJSON.getResults();
        Results results;
        String json;
        DateMap dateMap;

        ArrayList<String> dates = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            results = list.get(i);
            json = gson.toJson(results.getDateMap());
            dateMap = gson.fromJson(json, DateMap.class);
            dates.add(dateMap.getLocal());
        }

        return dates;
    }//end of getDates

    public ArrayList<Double> getValues() {
        MappingJSON mappingJSON = gson.fromJson(getResponse(), MappingJSON.class);
        List<Results> list = mappingJSON.getResults();
        Results results;

        ArrayList<Double> values = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            results = list.get(i);
            values.add(results.getValue());
        }

        return values;
    }//end of getValues

    public String getUnit() {
        MappingJSON mappingJSON = gson.fromJson(getResponse(), MappingJSON.class);
        List<Results> list = mappingJSON.getResults();
        Results results = list.get(0);

        String unit = results.getUnit();

        return unit;
    }//end of getUnit

}//end of class

