import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String pathFolders = "folder1/folder2/folder3";
        File dir = new File(pathFolders);
        File file1 = new File(pathFolders + "/filename1.txt");
        File file2 = new File(pathFolders + "/afile2.txt");
        File file3 = new File(pathFolders + "/filename3.txt");
        File file4 = new File(pathFolders + "/cat4.txt");
        File file5 = new File(pathFolders + "/apple5.txt");


        try {
            dir.mkdirs();
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
            file4.createNewFile();
            file5.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        File[] files = dir.listFiles((dir1, name) -> name.charAt(0) == 'a');

        for (File file : files){
            System.out.println(file.getAbsolutePath());
        }
    }
}
