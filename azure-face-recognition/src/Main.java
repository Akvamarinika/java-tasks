import java.net.HttpURLConnection;
import java.net.URL;
import java.io.*;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String URL_FOR_APIRequest = "https://westeurope.api.cognitive.microsoft.com/face/v1.0/detect?returnFaceId=true&returnFaceLandmarks=false&recognitionModel=recognition_04&returnRecognitionModel=false&detectionModel=detection_03&faceIdTimeToLive=86400";
    private static HttpURLConnection httpURLConnection = null;
    private static final String KEY = "01f0026ec4bc4880b6b8713dbd581e97";
    private static final String JSON_CONTENT = "{\"url\": \"https://4.bp.blogspot.com/-yAIaurHWbDs/UjcXMiM4QMI/AAAAAAAAWDI/sklohMF7XRA/w1200-h630-p-k-no-nu/changingface+ofyoda.jpg\"}";

    public static void main(String[] args) {
        try {
            APIRequest();
            uploadJSON();
            String json = getResponse();
            System.out.println(json);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void APIRequest() throws IOException {

        URL url = new URL(URL_FOR_APIRequest);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true); // set POST
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-type", "application/json");
        httpURLConnection.setRequestProperty("charset", "utf-8");
        httpURLConnection.setRequestProperty("Ocp-Apim-Subscription-Key", KEY);
        httpURLConnection.connect();
    }

    private static void uploadJSON() throws IOException {
        String jsonContent = "{\"url\": \"https://4.bp.blogspot.com/-yAIaurHWbDs/UjcXMiM4QMI/AAAAAAAAWDI/sklohMF7XRA/w1200-h630-p-k-no-nu/changingface+ofyoda.jpg\"}";
        try ( OutputStreamWriter  writer = new OutputStreamWriter(httpURLConnection.getOutputStream(), "UTF-8");) {
            writer.write(jsonContent);
            writer.close();

            System.out.println(httpURLConnection.getResponseMessage());
            for (Map.Entry<String, List<String>> header : httpURLConnection.getHeaderFields().entrySet()) {
                System.out.println(header.getKey() + "=" + header.getValue());
            }
        }
    }

    public static String getResponse() throws IOException {
        InputStream input = httpURLConnection.getInputStream();
        BufferedInputStream bufferIn = new BufferedInputStream(input);
        StringBuilder builder = new StringBuilder();
        byte[] array = new byte[1024];
        int count = bufferIn.read(array);
        while (count > 0){
            builder.append(new String(array, 0, count));
            count = bufferIn.read(array);
        }
        return builder.toString();
    }
}
