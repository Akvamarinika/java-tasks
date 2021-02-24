import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean sucessDir = false;
        boolean sucessFile = false;
        File folder = new File("folder1");
        sucessDir = folder.mkdir();
        File file = new File(folder,"text.txt");
        try {
            sucessFile = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Enter number page OR 'stop': ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            if (input.matches("\\d+")){
               int numberPage = Integer.parseInt(input);
                try(RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw")) {
                    byte[] array = new byte[3000];
                    randomAccessFile.seek((numberPage - 1) * array.length);
                    int count = randomAccessFile.read(array);
                    System.out.println(new String(array, 0, count));
                    System.out.println("Enter number page1 OR 'stop': ");
                    input = scanner.nextLine();
                } catch (IOException e){
                    e.printStackTrace();
                }

            }
        }
    }
}
