public class Test {
    public static void main(String[] args) {

        OpenAQPlatformAPI openAQPlatformAPI = new OpenAQPlatformAPI("Olsztyn" ,"pm10");
//        System.out.println(openAQPlatformAPI.getResponse());
        System.out.println(openAQPlatformAPI.getUnit());

    }//end of main
}//end of class
