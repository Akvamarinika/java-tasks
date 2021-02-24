import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cat cat1 = new Cat("Barsik", "Turkish", 3.5);
        Cat cat2 = new Cat("Marsik", "Burmese", 4.9);
        Cat cat3 = new Cat("Murka", "Siberian", 3.2);
        Cat cat4 = new Cat("Fluffy", "British", 3.3);
        Cat cat5 = new Cat("Peach", "Persian", 3.0);

        File file = new File("cats.cat");
        List<Cat> arrayList = new ArrayList<>();
        arrayList.add(cat1);
        arrayList.add(cat2);
        arrayList.add(cat3);
        arrayList.add(cat4);
        arrayList.add(cat5);

        writeObject(arrayList, file);

        List<Cat> cats = readObjects(file);
        for (Cat cat : cats){
            System.out.println(cat.getName());
        }

    }

    private static void writeObject(List<Cat> cat, File filename){

        if (!filename.exists()) {
            try {
                filename.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            objectOutputStream.writeObject(cat);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Cat> readObjects(File filename){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filename))){
            return  (List<Cat>) objectInputStream.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
