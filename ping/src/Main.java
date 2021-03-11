import java.io.*;
import java.nio.charset.Charset;

public class Main {
    public static void main(String[] args) {
        //writeFilePing();
        readAndWriteTimeSendPackage();

    }

   /* public static void ping(){
        Process ping = null;
        try {
            ping = Runtime.getRuntime().exec("ping -n 1000 google.com");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(ping.getInputStream(), Charset.forName("CP866")))){
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        }catch(IOException e){
            e.printStackTrace();
        }

    }*/

    public static void readAndWriteTimeSendPackage(){
        try(BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("filter.txt", true));
        ){
            String line;
            while ((line = br.readLine()) != null) {
                int strLen1 = "время=".length()-1;
                int strLen2 = "время=".length()-1;
                int idxStart = line.indexOf("время=") + strLen1;
                int idxEnd = line.indexOf("мс TTL");
                String time = line.substring(idxStart, idxEnd);
                bw.write(time + '\n');
                bw.flush();
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
