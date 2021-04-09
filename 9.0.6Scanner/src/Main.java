import java.io.*;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static Set<String> words = new TreeSet<>();
    public static void main(String[] args) {
        Main main = new Main();
        main.readFile("text.txt");
        main.printSet(words);
        main.writeFile("text2.txt");

    }

    public void readFile(String filename){
        try (Scanner scanner = new Scanner(new FileInputStream(filename))){
            while (scanner.hasNext()) {
                String word = scanner.next();
                scanner.useDelimiter("\\W+");
                words.add(word);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void printSet(Set<String> words){
        for (String word : words){
            System.out.println(word);
        }
    }

    public void writeFile(String filename){
        try (Writer writer = new FileWriter(filename)) {
            for (String word : words) {
                writer.write(word + "\n");
            }
        } catch (IOException e){
            e.printStackTrace();
        }

    }
}
