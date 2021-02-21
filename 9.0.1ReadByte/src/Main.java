import java.io.*;
public class Main {
    public static void main(String[] args) {
        File dir = new File("task2");
        File file = new File(dir.getPath() + "/text.txt");
        try {
            dir.mkdir();
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try(InputStream inputStream = new FileInputStream(file)){
            int bytes = inputStream.read();
            while (bytes != -1){
                System.out.print((char) bytes);
                bytes = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
