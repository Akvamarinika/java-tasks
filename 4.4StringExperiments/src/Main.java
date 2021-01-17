/*TODO:
*   Напишите код в проекте StringExperiments, который считает сумму заработка
   всех друзей (Васи, Пети и Маши).

* */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        printSymbol();
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);
        System.out.println("Всего заработали: " + earnings(text));




    }

    public static void printSymbol() {
        for (char symbol = 'a'; symbol < 'z'; symbol++) {
            System.out.print(symbol);
            System.out.println("\t" + (int) symbol);
        }
    }

    public static int earnings(String str){
        String vasyaStr = str.substring(str.indexOf("Вася"), str.indexOf(',')).trim();
        String petyaStr = str.substring(str.indexOf("Петя"), str.lastIndexOf(',')).trim();
        String mashaStr = str.substring(str.indexOf("Маша")).trim();
        String vasya = vasyaStr.substring("Вася заработал".length(), vasyaStr.indexOf("руб")).trim();
        String petya = petyaStr.substring("Петя -".length(), petyaStr.indexOf("руб")).trim();
        String masha = mashaStr.substring("Маша -".length(), mashaStr.indexOf("руб")).trim();
        return Integer.parseInt(vasya) + Integer.parseInt(petya) + Integer.parseInt(masha);
    }

}