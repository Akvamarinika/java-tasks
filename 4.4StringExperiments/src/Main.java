/*TODO:
*  Распечатайте коды всех букв английского алфавита и сами буквы.

* */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        printSymbol();




    }

    public static void printSymbol() {
        for (char symbol = 'a'; symbol < 'z'; symbol++) {
            System.out.print(symbol);
            System.out.println("\t" + (int) symbol);
        }
    }


}