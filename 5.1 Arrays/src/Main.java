/*TODO:
    1. Создайте массив из мнемонической фразы:
    Каждый охотник желает знать, где сидит фазан.
    2. Напишите код, который меняет порядок расположения элементов внутри массива на обратный.
    Пример Первоначальный массив: [“a”, “b”, “c”, “d”].
    Массив с элементами в обратном порядке: [“d”, “c”, “b”, “a”].

*  */
public class Main {
    public static void  main(String[] args){
    String str = "Каждый охотник желает знать, где сидит фазан.";
    String[] strArr = reverse(str);
    printArray(strArr);


    }
    public static String[] reverse(String text){
        String[] arrayStr = text.split("\\s+");
        for (int idx  = 0; idx < arrayStr.length / 2; idx++){
            String tmp = arrayStr[idx];
            arrayStr[idx] = arrayStr[arrayStr.length-1-idx];
            arrayStr[arrayStr.length-1-idx] = tmp;
        }
        return arrayStr;
    }

    public  static  void printArray(String[] words){
        for (String word : words){
            System.out.print(word + " ");
        }
    }
}

