import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

        OpenAQPlatformAPI openAQPlatformAPI = new OpenAQPlatformAPI("Katowice" ,"co", "100");
//        System.out.println(openAQPlatformAPI.getDates());
//        System.out.println(openAQPlatformAPI.getResponse());
//        System.out.println(openAQPlatformAPI.getLocation());
        openAQPlatformAPI.getResponse();
        System.out.println(openAQPlatformAPI.getResponse());
        System.out.println(openAQPlatformAPI.getDates());

//        System.out.println(openAQPlatformAPI.getValues().sort(openAQPlatformAPI.getValues());


    }//end of main
}//end of class
