import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.commons.csv.CSVRecord;

/*TODO 1.	Создать новый проект, который будет читать файл csv банковской выписки movementsList.csv и парсить полученные строки.
    Путь к файлу выписки храните в константе.
    2.	Код должен выводить сводную информацию по этой выписке: общий приход, общий расход и разбивку расходов.
*/
public class Main {
    public static final String FILE_PATH = "movementList.csv";
    public static void main(String[] args) {
        readCSV();
    }

    public static void readCSV(){
        try(BufferedReader buff = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while((line = buff.readLine()) != null){
                //System.out.println(line);
                String[] fragments = line.split("\\s+|,");

                if (fragments.length != 8){
                   // fragments.
                    System.out.println("Wrong line: " + line);
                    System.out.println(fragments.length);
                    printArray(fragments);
                    continue;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void printArray(String[] array){
        for (String s : array){
            System.out.println(s);
        }
    }
}
