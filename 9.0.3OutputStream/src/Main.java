import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        File file = new File("name.txt");
        System.out.println("Enter your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        while (!name.equals("exit")){
            writeInFile(name, file);
            name = scanner.nextLine();
        }
        readFromFile(file);

    }

    private static void writeInFile(String name, File fileName){
        try(OutputStream bufferOut = new BufferedOutputStream(new FileOutputStream(fileName, true))){
            bufferOut.write(name.getBytes());
            bufferOut.write("\n".getBytes());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void readFromFile(File fileName){
        try(InputStream bufferIn = new BufferedInputStream(new FileInputStream(fileName))) {
            StringBuilder builder = new StringBuilder();
            byte array[] = new byte[128];
            int count = bufferIn.read(array);
            while (count > 0){
                builder.append(new String(array, 0, count));
                count = bufferIn.read(array);
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
