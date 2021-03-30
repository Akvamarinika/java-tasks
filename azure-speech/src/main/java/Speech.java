import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import com.microsoft.cognitiveservices.speech.AudioDataStream;
import com.microsoft.cognitiveservices.speech.SpeechConfig;
import com.microsoft.cognitiveservices.speech.SpeechSynthesizer;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisOutputFormat;
import com.microsoft.cognitiveservices.speech.SpeechSynthesisResult;
import com.microsoft.cognitiveservices.speech.audio.AudioConfig;

import java.io.*;
import java.util.Scanner;

public class Speech {
    private static final String KEY = "be5f4c47488e4d349dbb06b527492c7c";
    private static final String REGION = "francecentral";
    private static final String AUTH_URL = "https://francecentral.api.cognitive.microsoft.com/sts/v1.0/issueToken";
    private static final String VOICES_URL = "https://francecentral.tts.speech.microsoft.com/cognitiveservices/voices/list";
    private static HttpURLConnection httpURLConnection = null;

    public static void main(String[] args) {
        try {
            String nameFile = getFileName();
            String myText = readText(nameFile);
            String token = getToken();
            System.out.println(token);
            getListOfAnnouncers(token);
            APIRequest(myText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getFileName() {
        System.out.println("Enter name source file name: ");
        String fileName = new Scanner(System.in).nextLine().trim();
        return fileName;
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

    public static void APIRequest(String yourText) {
       /* curl -X POST "https://francecentral.tts.speech.microsoft.com/cognitiveservices/v1" \
        -H "Authorization: Bearer <TOKEN>" \
        -H "X-Microsoft-OutputFormat: <FORMAT>" \
        -H "Content-Type: application/ssml+xml" \
        -H "User-Agent: <USER-AGENT>" \
        --output voice.wav \
        -d "<speak version='1.0' xml:lang='<LANG>'><voice xml:lang='<LANG>' xml:gender='<GENDER>' name='<NAME>'>I've Just seen A face</voice></speak>"*/
       /* SpeechConfig speechConfig = SpeechConfig.fromSubscription(KEY, REGION);
        AudioConfig audioConfig = AudioConfig.fromWavFileOutput("voice.wav");

        SpeechSynthesizer synthesizer = new SpeechSynthesizer(speechConfig, audioConfig);
        synthesizer.SpeakText("A simple test to write to a file.");*/

        String gender = "MALE";
        String voice = "bg-BG-Ivan";
        String requestBody = "<speak version='1.0' xml:lang='en-US'><voice xml:lang='en-US' xml:gender='" + gender + "' name='" + voice + "'>" + yourText + "</voice></speak>";

        SpeechConfig speechConfig = SpeechConfig.fromSubscription(KEY, REGION);
        AudioConfig audioConfig = AudioConfig.fromWavFileOutput("path/to/write/file.wav");

        SpeechSynthesizer synthesizer = new SpeechSynthesizer(speechConfig, null);

        SpeechSynthesisResult result = synthesizer.SpeakSsml(requestBody);
        AudioDataStream stream = AudioDataStream.fromResult(result);
        stream.saveToWavFile("voice.wav");
    }

    public static void averageCharDurationInSec(){

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
