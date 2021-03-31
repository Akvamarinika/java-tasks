import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Speech {
    private static final String KEY = "1db01788ad86488d90d573a7fe502c11";
    private static final String REGION = "eastasia";
    private static final String AUTH_URL = "https://eastasia.api.cognitive.microsoft.com/sts/v1.0/issueToken";
    private static final String VOICES_URL = "https://eastasia.tts.speech.microsoft.com/cognitiveservices/voices/list";
    private static HttpURLConnection httpURLConnection = null;

    public static void main(String[] args) {
        try {
            String nameFile = getFileName();
            String newFileName = nameFile.substring(0,nameFile.indexOf(".")) + ".wav";
            String myText = readText(nameFile);
            String token = getToken();
            System.out.println(token);
            getListOfAnnouncers(token);
            APIRequest(myText, token);
            writeInBinaryFileWav(newFileName);
            averageCharDurationInSec(newFileName, myText);
            httpURLConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileName() {
        System.out.println("Enter name source file name: ");
        return new Scanner(System.in).nextLine().trim();
    }

    public static String readText(String fileName) throws IOException {
        String line;
        StringBuilder builder = new StringBuilder();
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while ((line = reader.readLine()) != null){
                builder.append(line);
                builder.append('\n');
            }
        }
        return builder.toString();
    }

    public static void getListOfAnnouncers(String myToken) throws IOException {
        URL url = new URL(VOICES_URL);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + myToken);
        System.out.println(getResponse());

    }

    public static void APIRequest(String yourText, String myToken) throws IOException {
        String gender = "Male";
        String voice = "en-US-GuyRUS";
        String POSTText = "<speak version='1.0' xml:lang='en-US'><voice xml:lang='en-US' xml:gender='" + gender + "' name='" + voice + "'>" + yourText + "</voice></speak>";
        //String POSTText = "<speak version='1.0' xml:lang='en-US'><voice xml:lang='en-US' xml:gender='Female' name='en-US-AriaRUS'>I've Just seen A face</voice></speak>";
        URL url = new URL("https://eastasia.tts.speech.microsoft.com/cognitiveservices/v1");
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoOutput(true); // set POST
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + myToken);
        httpURLConnection.setRequestProperty("X-Microsoft-OutputFormat", "riff-16khz-16bit-mono-pcm");
        httpURLConnection.setRequestProperty("Content-Type", "application/ssml+xml");
        httpURLConnection.setRequestProperty("User-Agent", "CURL 111");

        try (OutputStream output = httpURLConnection.getOutputStream()) {
            output.write(POSTText.getBytes());
        }

        for (Map.Entry<String, List<String>> header : httpURLConnection.getHeaderFields().entrySet()) {
            System.out.println(header.getKey() + "=" + header.getValue());
        }

    }

       public static void writeInBinaryFileWav(String fileName){
        try(BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName));
            BufferedInputStream bufferIn = new BufferedInputStream(httpURLConnection.getInputStream())){
            out.flush();
            out.write(bufferIn.readAllBytes());
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void averageCharDurationInSec(String fileName, String myText) throws IOException{
        try {
            File file = new File(fileName);
            WavFile wavFile = new WavFile(file);
            System.out.println("\nРазмер файла в байтах: ");
            System.out.println(wavFile.getWavLength());
            System.out.println("Длительность файла в сек: ");
            System.out.println(wavFile.getDurationTime());
            System.out.println("Длительность одного символа в сек: ");
            System.out.println(wavFile.getDurationSymbol(myText.length()));
        } catch (UnsupportedAudioFileException e) {
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
        byte[] array = new byte[1024];
        int count = bufferIn.read(array);
        while (count > 0){
            builder.append(new String(array, 0, count));
            count = bufferIn.read(array);
        }
        //System.out.println(builder.toString());
        //httpURLConnection.disconnect();
        return builder.toString();
    }
}
