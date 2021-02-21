import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        File file = new File("task2/text.txt");
        char[] arrayChars = new char[128];

        try(Reader readerStream = new InputStreamReader(new FileInputStream(file))){
            int count = readerStream.read(arrayChars);
            while (count > 0){
                sb.append(new String(arrayChars));
                count = readerStream.read(arrayChars);
            }
        } catch (IOException e){
            e.printStackTrace();
        }

        String[] names = sb.toString().split(" ");
        Arrays.stream(names)
                .filter(name -> name.startsWith("A"))
                .forEach(System.out::println);
    }
}
