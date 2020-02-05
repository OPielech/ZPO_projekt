import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class OpenAQPlatformAPI {
    private String city;
    private String parameter;
    Gson gson = new Gson();

    public OpenAQPlatformAPI(String city, String parameter) {
        this.city = city;
        this.parameter = parameter;
    }


    public String getResponse() {

        String response1 = null;
        StringBuffer response = new StringBuffer();
        String url = "https://api.openaq.org/v1/measurements?city=" + city + "&parameter=" + parameter;
//        String url = "https://api.openaq.org/v1/cities?country=PL&limit=1";

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

//    public String getDate() {
//        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
//        String result = map.get("results").toString();
//        String[] results = result.split(",");
//        String date = results[2].substring(13,23);
//        System.out.println(date);
//
//        return date;
//    }//end of getDate

    public ArrayList getDates() {
        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
        String result = map.get("results").toString();
        String[] results = result.split(",");
        ArrayList<String> dates = new ArrayList<>();

        for (int i=0; i<results.length;i++) {

            if (i%10 == 0)
           dates.add(results[2+i].substring(13,23));
        }

        return dates;
    }//end of getDates

    public ArrayList getValues(){
        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
        String result = map.get("results").toString();
        String[] results = result.split(",");
        ArrayList<Double> values = new ArrayList<>();

        for (int i=0; i<results.length;i++) {

            if (i%10 == 0)
                values.add(Double.parseDouble(results[4+i].substring(7)));
        }

        System.out.println(values);
        return values;
    }//end of getValues

    public ArrayList getLocalTime(){
        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
        String result = map.get("results").toString();
        String[] results = result.split(",");
        ArrayList<String> localTimes = new ArrayList<>();

        if (results[2].charAt(7)=='u') {
            for (int i = 0; i < results.length; i++) {

                if (i % 10 == 0)
                    localTimes.add(results[3 + i].substring(18, 32));
            }
        }else {
            for (int i = 0; i < results.length; i++) {

                if (i % 10 == 0)
                    localTimes.add(results[2 + i].substring(24));
            }
        }
        System.out.println(localTimes);
        return localTimes;
    }//end of getLocalTime

    public ArrayList getUTCTime(){
        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
        String result = map.get("results").toString();
        String[] results = result.split(",");
        ArrayList<String> utcTimes = new ArrayList<>();

        if (results[2].charAt(7)=='u') {
            for (int i = 0; i < results.length; i++) {

                if (i % 10 == 0)
                    utcTimes.add(results[2 + i].substring(23));
            }
        }else {
            for (int i = 0; i < results.length; i++) {

                if (i % 10 == 0)
                    utcTimes.add(results[3 + i].substring(16,29));
            }
        }
        System.out.println(utcTimes);
        return utcTimes;
    }//end of getUTCTime

    public String getUnit(){
        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
        String result = map.get("results").toString();
        String[] results = result.split(",");

        String unit = results[5].substring(6);
        System.out.println(unit);

        return unit;
    }//end of getUnit

}//end of class