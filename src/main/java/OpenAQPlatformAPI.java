//import com.google.gson.Gson;
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.Map;
//
//public class OpenAQPlatformAPI {
//    private String city;
//    private String parameter;
//    private String limit;
//    Gson gson = new Gson();
//
//    public OpenAQPlatformAPI(String city, String parameter, String limit) {
//        this.city = city;
//        this.parameter = parameter;
//        this.limit = limit;
//    }
//
//    public String getCity() {
//        return city;
//    }
//
//    public String getParameter() {
//        return parameter;
//    }
//
//    public String getLimit() {
//        return limit;
//    }
//
//    public String getResponse() {
//
//        String response1 = null;
//        StringBuffer response = new StringBuffer();
//        String url = "https://api.openaq.org/v1/measurements?city=" + city + "&parameter=" + parameter +"&limit=" + limit;
//
//        try {
//            URL obj = new URL(url);
//            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();
//            connection.setRequestMethod("GET");
//            int responseCode = connection.getResponseCode();
//
//            String inputLine;
//            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
//            while ((inputLine = in.readLine()) != null) {
//                response.append(inputLine);
//            }
//            response1 = response.toString();
//
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return response1;
//    }//end of getResponse
//
//    public ArrayList getDates() {
//        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
//        String result = map.get("results").toString();
//        String[] results = result.split(",");
//        ArrayList<String> dates = new ArrayList<>();
//
//
//
//        if (results[2].charAt(7)=='u') {
//            for (int i = 0; i < results.length; i++) {
//
//                if (i % 10 == 0)
//                    dates.add(results[2 + i].substring(11, 21));
//            }
//        }else {
//            for (int i=0; i<results.length;i++) {
//
//                if (i%10 == 0)
//                    dates.add(results[2+i].substring(13,23));
//            }
//        }
//
//        return dates;
//    }//end of getDates
//
//    public ArrayList<Double> getValues(){
//        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
//        String result = map.get("results").toString();
//        String[] results = result.split(",");
//        ArrayList<Double> values = new ArrayList<>();
//
//        for (int i=0; i<results.length;i++) {
//
//            if (i%10 == 0)
//                values.add(Double.parseDouble(results[4+i].substring(7)));
//        }
//
//        return values;
//    }//end of getValues
//
//    public ArrayList getLocalTime(){
//        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
//        String result = map.get("results").toString();
//        String[] results = result.split(",");
//        ArrayList<String> localTimes = new ArrayList<>();
//
//        if (results[2].charAt(7)=='u') {
//            for (int i = 0; i < results.length; i++) {
//
//                if (i % 10 == 0)
//                    localTimes.add(results[3 + i].substring(18, 32));
//            }
//        }else {
//            for (int i = 0; i < results.length; i++) {
//
//                if (i % 10 == 0)
//                    localTimes.add(results[2 + i].substring(24));
//            }
//        }
//        return localTimes;
//    }//end of getLocalTime
//
//    public ArrayList getUTCTime(){
//        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
//        String result = map.get("results").toString();
//        String[] results = result.split(",");
//        ArrayList<String> utcTimes = new ArrayList<>();
//
//        if (results[2].charAt(7)=='u') {
//            for (int i = 0; i < results.length; i++) {
//
//                if (i % 10 == 0)
//                    utcTimes.add(results[2 + i].substring(23));
//            }
//        }else {
//            for (int i = 0; i < results.length; i++) {
//
//                if (i % 10 == 0)
//                    utcTimes.add(results[3 + i].substring(16,29));
//            }
//        }
//        return utcTimes;
//    }//end of getUTCTime
//
//    public String getUnit(){
//        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
//        String result = map.get("results").toString();
//        String[] results = result.split(",");
//
//        String unit = results[5].substring(6);
//
//
//        return unit;
//    }//end of getUnit
//
//
//
////    public ArrayList getLocation(){
////        Map map = gson.fromJson(String.valueOf(getResponse()), Map.class);
////        String result = map.get("results").toString();
////        String[] results = result.split(",");
////        ArrayList<String> locations = new ArrayList<>();
////
////
////        for (int i = 0; i < results.length; i++) {
////
////            if (i % 10 == 0)
////                locations.add(results[i].substring(9));
////
////        }
////
////        System.out.println(locations);
////
////        return locations;
////    }//end of getLocation
//
//}//end of class

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

