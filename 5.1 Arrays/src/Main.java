/*TODO:
    1.	Создайте массив типа float с температурами 30 пациентов (от 32 до 40 градусов).
    2.	Напишите код, который выводит среднюю температуру по больнице и количество здоровых пациентов
    (с температурой от 36,2 до 36,9), а также температуры всех пациентов.
    Вынесите в константы условия задания:
    •	количество пациентов,
    •	минимальная и максимальная температура пациентов,
    •	минимальная и максимальная температура диапазона здоровых пациентов.

*  */
import  java.lang.Math;
public class Main {
    public static void  main(String[] args){
    String str = "Каждый охотник желает знать, где сидит фазан.";
    String[] strArr = reverse(str);
    printArray(strArr);

    float[] arrSick = temperatureRandom();
    printArrayFloat(arrSick);


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

    public static float[] temperatureRandom(){
         final int COUNT_T = 30;
         float[] arrSick = new float[COUNT_T];
        for (int idx  = 0; idx < arrSick.length; idx++){
            arrSick[idx] =  (float)(Math.round((Temperature.MIN_SICK.getValue() + Math.random() * (Temperature.MAX_SICK.getValue() - Temperature.MIN_SICK.getValue()) )* 100.0)  / 100.0);
         }
         return arrSick;
    }

    public static void printArrayFloat(float[] values){
        int countHealthy = 0;
        float avg = 0;
        System.out.print("\nТемпературы пациентов: ");
        for (float val : values){
            if (Temperature.MIN_HEALTHY.getValue() < val && Temperature.MAX_HEALTHY.getValue() > val ){countHealthy++;}
            avg +=  val;
            System.out.print(val + " ");
        }
        System.out.println("\nСредняя температура: " + avg / values.length);
        System.out.println("Количество здоровых: " + countHealthy);
    }


}

