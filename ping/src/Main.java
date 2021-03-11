import java.io.*;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, Integer> timeCount = new HashMap<>();
    public static void main(String[] args) {
        //writeFilePing();
        readAndWriteTimeSendPackage();
        System.out.println(timeCount);

    }

    public static void counter(String timeKey){
        if (timeCount.containsKey(timeKey)){
            int value = timeCount.get(timeKey) + 1;
            timeCount.put(timeKey, value);
        }else {
            timeCount.put(timeKey, 1);
        }
    }

    public static void readAndWriteTimeSendPackage(){
        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("filter.txt"))
        ){
            String line;
            while ((line = br.readLine()) != null) {
                int strLen = "время=".length();
                int idxStart = line.indexOf("время=") + strLen;
                int idxEnd = line.indexOf("мс TTL");
                if (idxStart != -1 && idxEnd != -1) {
                    String time = line.substring(idxStart, idxEnd);
                    counter(time);
                    bw.write(time + '\n');
                    bw.flush();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void writeFilePing(){
        Process ping = null;
        try {
            ping = Runtime.getRuntime().exec("ping -n 1000 google.com");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(ping.getInputStream(), Charset.forName("CP866")));
            BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt"))
        ){
            String line;
            while ((line = br.readLine()) != null) {
                bw.write(line + '\n');
                bw.flush();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
