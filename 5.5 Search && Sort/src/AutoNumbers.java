import java.util.*;

/*TODO
*  1. Напишите генератор «красивых» автомобильных номеров и методы поиска элементов в коллекциях:
    •	прямым перебором по ArrayList,
    •	бинарным поиском по сортированному ArrayList,
    •	поиском в HashSet,
    •	поиском в TreeSet.
   2. Измерьте и сравните длительность каждого метода поиска.
*/

/*
* 17910000
Введите номер для поиска:
М670УВ55
Прямой перебор ArrayList:
Номер НЕ найден! -240037547 нс
Бинарный поиск в ArrayList:
Номер НЕ найден! -79534 нс
Поиск в HashSet:
Номер НЕ найден! -124110 нс
Поиск в TreeSet:
Номер НЕ найден! -37522 нс
*
*
* Р451СН192
Прямой перебор ArrayList:
Номер найден! -278272635 нс
Бинарный поиск в ArrayList:
Номер найден! -78250 нс

* */

public class AutoNumbers {
    private static ArrayList<String> numbers = new ArrayList<>();
    private static HashSet<String> hashSetNumbers = new HashSet<>(numbers);
    private static TreeSet<String> treeSetNumbers = new TreeSet<>(numbers);
    private final static String[] SYMBOLS = new String[]{"А", "В", "С", "Е", "М", "Н", "О", "Р", "Т", "У"};
    public static void main(String[] args){
        generatorNumbers();
        System.out.println(numbers.size());
        while (true) {
            System.out.println("Введите номер для поиска: ");
            String input = new Scanner(System.in).nextLine();
            directSearch(numbers, input);
            binarySearch(numbers, input);
            hashSearch(hashSetNumbers, input);
            treeSearch(treeSetNumbers, input);
        }
    }

    private static ArrayList<String> generatorNumbers(){
        for (int region = 1; region<200; region++){
            for(String x : SYMBOLS){
                for (String y : SYMBOLS){
                    for (String z : SYMBOLS){
                        for (int num = 11; num < 1000; num += 11){
                            numbers.add(String.format("%s%d%s%s%d",x,num,y,z,region));
                            //System.out.println(String.format("%s%d%s%s%d",x,num,y,z,region));
                        }
                    }
                }
            }
        }
        return numbers;
    }

    private static void directSearch(ArrayList<String> numbers, String findNumber){
        System.out.println("Прямой перебор ArrayList: ");
        boolean flag = false;
        long start = System.nanoTime();
        for (String number : numbers){
            if (findNumber.equals(number)){
                System.out.println("Номер найден! " + (start - System.nanoTime()) + " нс");
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("Номер НЕ найден! " + (start - System.nanoTime()) + " нс");
        }
    }

    private static void binarySearch(ArrayList<String> numbers, String findNumber){
        System.out.println("Бинарный поиск в ArrayList: ");
        Collections.sort(numbers);
        long start = System.nanoTime();
        int result = Collections.binarySearch(numbers, findNumber);
        if (result >= 0){
            System.out.println("Номер найден! " + (start - System.nanoTime()) + " нс");
        }else {
            System.out.println("Номер НЕ найден! " + (start - System.nanoTime()) + " нс");
        }
    }

    private static void hashSearch(HashSet<String> hashSetNumbers, String findNumber){
        System.out.println("Поиск в HashSet: ");
        long start = System.nanoTime();
        if (hashSetNumbers.contains(findNumber)){
            System.out.println("Номер найден! " + (start - System.nanoTime()) + " нс");
        } else {
            System.out.println("Номер НЕ найден! " + (start - System.nanoTime()) + " нс");
        }
    }

    private static void treeSearch(TreeSet<String> treeSetNumbers, String findNumber){
        System.out.println("Поиск в TreeSet: ");
        long start = System.nanoTime();
        if (treeSetNumbers.contains(findNumber)){
            System.out.println("Номер найден! " + (start - System.nanoTime()) + " нс");
        } else {
            System.out.println("Номер НЕ найден! " + (start - System.nanoTime()) + " нс");
        }
    }


}
