import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("name.txt");
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        while (!name.equals("exit")){
            writeInFile("\n" + name, file);
            name = scanner.nextLine();
        }
        readFromFile(file);

    }

    private static void writeInFile(String name, File fileName){
        try(OutputStream out = new FileOutputStream(fileName, true)){
            out.write(name.getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void readFromFile(File fileName){
        try(InputStream bufferIn = new BufferedInputStream(new FileInputStream(fileName))) {
            StringBuilder builder = new StringBuilder();
            int count = bufferIn.read();
            while (count != -1){
                builder.append((char) count);
                count = bufferIn.read();
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
