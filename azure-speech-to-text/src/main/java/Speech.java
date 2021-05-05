import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Speech {
    private static final String KEY = "8c085e691b2940e091e3a4bdf2804a60";
    private static final String URL_FOR_APIRequest = "https://westeurope.stt.speech.microsoft.com/speech/recognition/conversation/cognitiveservices/v1?language=en-US&format=simple";

    private static final String AUTH_URL = "https://westeurope.api.cognitive.microsoft.com/sts/v1.0/issueToken";
    private static final String VOICES_URL = "https://westeurope.tts.speech.microsoft.com/cognitiveservices/voices/list";

    private static HttpURLConnection httpURLConnection = null;
    private static String locale;
    private static String speaker;
    private static String gender;

    public static void main(String[] args) {
        try {
            String nameFile = getFileName();
            String newFileName = nameFile.substring(0,nameFile.indexOf(".")) + ".txt";
          //  String myText = readText(nameFile);
            String token = getToken();
            System.out.println(token);


            //selectSpeakersAndLanguage();
            APIRequest(token, nameFile);
            String json = getResponse();

            Transcription transcription = parseJSON(json);
            System.out.println("DisplayText: " + transcription.getDisplayText());
            System.out.println("Duration: " + transcription.getDuration());
            writeInFile(newFileName, transcription.getDisplayText());
            averageCharDurationInSec(nameFile, transcription.getDisplayText());
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

    public static Transcription parseJSON(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Transcription transcription = mapper.readValue (json, Transcription.class);
        return transcription;
    }


    public static void APIRequest(String myToken, String fileName) throws IOException {
        URL url = new URL(URL_FOR_APIRequest);
        httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true); // set POST
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Content-type", "audio/wav; codecs=\"audio/pcm\"; samplerate=16000");
        httpURLConnection.setRequestProperty("Authorization", "Bearer " + myToken);
        httpURLConnection.setRequestProperty("Accept", "application/json;text/xml");
        httpURLConnection.setRequestProperty("Transfer-Encoding", "chunked");
        httpURLConnection.setRequestProperty("Expect", "100-continue");
        httpURLConnection.setChunkedStreamingMode(0); // 0 == default chunk size
        httpURLConnection.connect();
        InputStream inputStream = new FileInputStream(fileName);
        upload(inputStream);

        for (Map.Entry<String, List<String>> header : httpURLConnection.getHeaderFields().entrySet()) {
            System.out.println(header.getKey() + "=" + header.getValue());
        }


    }

    private static void upload(InputStream inputStream) throws IOException {
        try (OutputStream output = httpURLConnection.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                output.write(buffer, 0, length);
            }
            output.flush();
        }}

       public static void writeInFile(String fileName, String text){
        try(OutputStream out = new FileOutputStream(fileName)){
            out.flush();
            out.write(text.getBytes());
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
