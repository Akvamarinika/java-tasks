import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Translator {
    private static String key = "";
    private static String region = "westeurope";
    private static String API_URL = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=es";
    private static String POSTtext = "[{'Text':'Hello, world!'}]";
    private static String from = "en";
    private static String to = "es";
    public static void main(String[] args) throws Exception {
        if (args.length > 1) {
            String fileName = args[0];
            String to = args[1];
        } else {
            throw new Exception();
        }

        URL url = new URL(API_URL);
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true); // get POST

        httpURLConnection.setRequestProperty("Ocp-Apim-Subscription-Key", key);
        httpURLConnection.setRequestProperty("Ocp-Apim-Subscription-Region", region);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");


        OutputStream out = httpURLConnection.getOutputStream();
        out.write(POSTtext.getBytes());

        Scanner in = new Scanner(httpURLConnection.getInputStream());
        if (in.hasNext()) {
            System.out.println(in.nextLine());
        } else System.out.println("No output returned");
        httpURLConnection.disconnect();
    }

    public static void inputUser(){

    }
}
