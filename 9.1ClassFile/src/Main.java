import java.io.File;
import java.util.Scanner;
public class Main {
    /*TODO
        •	получать через консоль путь от пользователя до папки;
        •	суммировать размер файлов папки и вложенных папок;
        •	выводить полученную сумму файлов в удобочитаемом виде — в байтах, килобайтах, мегабайтах или гигабайтах;

    */
    private static final int CAPACITY = 1024;
    private static long sizeMain = 0;
    public static void main(String[] args) {
        System.out.println("Введите путь к папке: ");
        String path = new Scanner(System.in).nextLine();
        File folder = new File(path);
        if (folder.isDirectory()){
            folderSumFileSize(folder);
        }

        System.out.println("Размер папки " + folder.getAbsolutePath() + ":");
        System.out.println(sizeMain + " bytes");
        System.out.println(sizeMain / CAPACITY + " kb");
        System.out.println(sizeMain / (CAPACITY * CAPACITY) + " mb");
        System.out.println(sizeMain / (CAPACITY * CAPACITY * CAPACITY) + " Gb");

    }

    private static long folderSumFileSize( File folderName){
        for (File file : folderName.listFiles()){
            if (file.isDirectory()){
                folderSumFileSize(file);
            }
            sizeMain += file.length();
        }
        return sizeMain;
    }
}