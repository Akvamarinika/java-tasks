
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*TODO
    •	Напишите код, который копирует одну указанную папку в другую. При копировании должны сохраниться файлы и структура папки.
    •	Папки запрашивайте у пользователя в консоли.
    •	Программа должна перехватывать все исключения, возникающие при ошибках чтения файлов и папок, и выводить сообщение об ошибке с трассировкой стека (stack trace).
*/
public class Main {
    public static void main(String[] args) {
        File folderOriginal = new File("C:/Users/Admin/Desktop");
        System.out.println(folderOriginal.getName());
        String pathCopy = "C:/" + folderOriginal.getName();
        new File(pathCopy).mkdir();
        Path pathsForCopy = Paths.get(pathCopy);
        if (folderOriginal.listFiles() != null){
            copyFolder(folderOriginal, pathsForCopy);
        }


    }

    private static void copyFolder(File folderOrig, Path pathCopy){
        try {
            for (File f : folderOrig.listFiles()){
                Files.copy(f.toPath(), pathCopy.resolve(f.getName()), StandardCopyOption.REPLACE_EXISTING);
                if (f.isDirectory()){
                    copyFolder(f, pathCopy.resolve(f.getName()));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}