/*TODO:
    Напишите программу, которая на входе через консоль принимает фамилию, имя и отчество одной строкой
    (например, «Иванов Сергей Петрович») и выводит фамилию, имя и отчество отдельно.


* */
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        printSymbol();
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        System.out.println(text);
        System.out.println("Всего заработали: " + earnings(text));
        String txt = "Номер кредитной карты <4008 1234 5678> 8912, номер кредитной карты <1548 1258 1452> 4580";
        //printWithIndexes(txt);
        System.out.println(searchAndReplaceDiamonds(txt, "***"));

        System.out.println("Введите ФИО: ");
        String input = new Scanner(System.in).nextLine();
        printFullName(input);


    }






    public static void printSymbol() {
        for (char symbol = 'a'; symbol < 'z'; symbol++) {
            System.out.print(symbol);
            System.out.println("\t" + (int) symbol);
        }

        for (char symbol = 'а'; symbol < 'я'; symbol++) {
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

    public static StringBuilder searchAndReplaceDiamonds(String text, String placeholder){
        StringBuilder buildStr = new StringBuilder();
        int idx= -1;
        int leftDiamondIdx = 0;
        while (leftDiamondIdx != -1){
            leftDiamondIdx = text.indexOf("<", idx);
            if (leftDiamondIdx != -1) {
                buildStr.append(text, idx + 1, leftDiamondIdx).append(placeholder);      //buildStr.append(text.substring(idx + 1, leftDiamondIdx)).append(placeholder);
                idx = text.indexOf(">", leftDiamondIdx);
            } else {
                buildStr.append(text.substring(idx + 1));

            }
        }
        return buildStr;

    }

    public  static void printFullName(String str){
        //str = "Иванов Сергей Петрович";
        String firstName = str.substring(0, str.indexOf(" ") + 1);
        System.out.println(str);
        String surname = str.substring(firstName.length(), str.indexOf(" ",firstName.length() + 1));
        int idx = surname.length() + firstName.length();
        String patronymic = str.substring(idx).trim();

        if (!firstName.isEmpty()){
            System.out.println("Фамилия: " + firstName);
        }
        if (!surname.isEmpty()){
            System.out.println("Имя: " + surname);
        }
        if (!patronymic.isEmpty()){
            System.out.println("Отчество: " + patronymic);
        }

    }

    private static void printWithIndexes(String string) {
        StringBuilder letters = new StringBuilder().append("char: ");
        StringBuilder indexes = new StringBuilder().append("index:");
        for (int i = 0; i < string.length(); i++) {
            letters.append(String.format("%3s", string.charAt(i)));
            indexes.append(String.format("%3d", i));
        }
        System.out.println(letters);
        System.out.println(indexes.append(System.lineSeparator()));
    }

}