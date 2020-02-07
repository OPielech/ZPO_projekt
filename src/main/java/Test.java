import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        OpenAQPlatformAPI openAQPlatformAPI = new OpenAQPlatformAPI("Olsztyn" ,"pm10", "1000");
//        System.out.println(openAQPlatformAPI.getResponse());
//        System.out.println(openAQPlatformAPI.getLocation());
        openAQPlatformAPI.getResponse();
        System.out.println(openAQPlatformAPI.getDates());
        System.out.println(openAQPlatformAPI.getResponse());
//        System.out.println(openAQPlatformAPI.getValues().sort(openAQPlatformAPI.getValues());

        ArrayList<Double> test = openAQPlatformAPI.getValues();
        double size;
        size = openAQPlatformAPI.getValues().size();

        Double min = test.get(0);

        for (int i = 0; i<size; i++){
            if (test.get(i) <min)
                min = test.get(i);
        }

        System.out.println(min.toString());
        System.out.println("sada");
    }//end of main
}//end of class
