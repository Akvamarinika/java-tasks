import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Speech {
    private static final String KEY = "be5f4c47488e4d349dbb06b527492c7c";
    private static final String REGION = "francecentral";
    private static final String AUTH_URL = "https://francecentral.api.cognitive.microsoft.com/sts/v1.0/issueToken";
    private static HttpURLConnection httpURLConnection = null;

    public static void main(String[] args) {
        try {
            String token = getToken();
            System.out.println(token);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getToken() throws IOException {
        sendRequest();
        return getResponse();
    }

    public static void sendRequest() throws IOException {
        String POSTText = "";
        URL url = new URL(AUTH_URL);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true); // set POST
        httpURLConnection.setRequestProperty("Ocp-Apim-Subscription-Key", KEY);
        httpURLConnection.setRequestProperty("Content-Length", "0");
        httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        try (OutputStream output = httpURLConnection.getOutputStream()) {
            output.write(POSTText.getBytes());
        }
    }

    public static String getResponse() throws IOException {
        InputStream input = httpURLConnection.getInputStream();
        BufferedInputStream bufferIn = new BufferedInputStream(input);
        StringBuilder builder = new StringBuilder();
        byte[] array = new byte[512];
        int count = bufferIn.read(array);
        while (count > 0){
            builder.append(new String(array, 0, count));
            count = bufferIn.read(array);
        }
        //System.out.println(builder.toString());
        httpURLConnection.disconnect();
        return builder.toString();
    }
}
