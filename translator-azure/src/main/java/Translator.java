

import netscape.javascript.JSObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Scanner;

public class Translator {
    private static HttpURLConnection httpURLConnection = null;
    private static final String KEY = "";
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
        parseJSON(stringJson);




    }

    public static String readText(String fileName){
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String line;
            StringBuilder builder = new StringBuilder();
            while ((line = reader.readLine()) != null){
                builder.append(line + '\n');
            }
            return builder.toString();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
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
        if (in.hasNext()) {
            //System.out.println(in.nextLine());
            return in.nextLine();
        } else System.out.println("No output returned");
        httpURLConnection.disconnect();
        return null;
    }

    public static void parseJSON(String response){
        try {
            //JSONParser parser = new JSONParser();
            //JSONObject jsonData = (JSONObject) parser.parse(response);
            JSONArray jsonArray= (JSONArray) JSONValue.parseWithException(response);
            JSONObject jsonData = (JSONObject ) jsonArray.get(0);
            JSONArray translateArr = (JSONArray) jsonData.get("translations");

            JSONObject translateData = (JSONObject) translateArr.get(0);
            System.out.println(translateData.get("text") + "to: " + translateData.get("to"));

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public static void writeText(String fileName, String text){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.flush();
            writer.write(text);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
