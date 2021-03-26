
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Translator {
    private static HttpURLConnection httpURLConnection = null;
    private static final String KEY = " "; //9bf007a897f54e4a94203f8aa88cd2b1
    private static final String REGION = "westeurope";
    private static String API_URL = "https://api.cognitive.microsofttranslator.com/translate?api-version=3.0&to=";
    private static String POSTtext = "[{'Text':'Hello, world!'}]";

    public static void main(String[] args) throws Exception {
        if (args.length == 2) {
            String fileName = args[0];
            POSTtext = "[{'Text':'" + readText(fileName) + "'}]";

            String toLang = args[1];
            API_URL += toLang;
        } else {
            throw new Exception();
        }

        sendRequest();
        String stringJson = getResponse();
        String translateText = parseJSON(stringJson);
        String fileName = "Translate_" + args[1] + '_' + args[0];
        writeText(fileName, translateText);

    }

    public static String readText(String fileName){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null){
                builder.append(line);
                builder.append('\n');
            }
            return builder.toString();
        } catch (IOException e){
            e.printStackTrace();
        }

        return null;
    }

    public static void sendRequest() throws IOException {
        URL url = new URL(API_URL);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true); // set POST

        httpURLConnection.setRequestProperty("Ocp-Apim-Subscription-Key", KEY);
        httpURLConnection.setRequestProperty("Ocp-Apim-Subscription-Region", REGION);
        httpURLConnection.setRequestProperty("Content-Type", "application/json");

        OutputStream out = httpURLConnection.getOutputStream();
        out.write(POSTtext.getBytes());
    }

    public static String getResponse() throws IOException {
        Scanner in = new Scanner(httpURLConnection.getInputStream());
        String response;
        if (in.hasNext()) {
            response = in.nextLine();
            System.out.println("Response: " + response);
            return response;
        } else System.out.println("No output returned");
        httpURLConnection.disconnect();
        return null;
    }

    public static String parseJSON(String response){
        try {
            JSONArray jsonArray= (JSONArray) JSONValue.parseWithException(response);
            JSONObject jsonData = (JSONObject ) jsonArray.get(0);
            JSONArray translateArr = (JSONArray) jsonData.get("translations");

            JSONObject translateData = (JSONObject) translateArr.get(0);
           // System.out.println(translateData.get("text") + "to: " + translateData.get("to"));
            return (String) translateData.get("text");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writeText(String fileName, String text){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.flush();
            writer.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
