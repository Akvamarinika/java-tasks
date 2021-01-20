/*TODO:
    Создайте с помощью циклов двумерный массив строк. При его распечатке в консоли должен выводиться крестик из X:
    x     x
     x   x
      x x
       x
      x x
     x   x
    x     x

*  */
import  java.lang.Math;
public class Main {
    public static void  main(String[] args){
        String str = "Каждый охотник желает знать, где сидит фазан.";
        String[] strArr = reverse(str);
        printArray(strArr);

        float[] arrSick = temperatureRandom();
        printArrayFloat(arrSick);

        String[][] arrX = generateX();
        printX(arrX);


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

    public static String[][] generateX(){
        String[][] arrX = new String[7][7];
        for (int i = 0; i < arrX.length; i++){
            for (int j = 0; j < arrX[i].length; j++){
                if (i == j){
                    arrX[i][j] = "X";
                }else if(i+j == arrX.length - 1){
                    arrX[i][j] = "X";
                }else {
                    arrX[i][j] = " ";
                    //arrX[i][arrX[i].length-1-i] = "X";
                }


            }
        }
        return arrX;
    }

    public static void printX(String[][] arrX){
        for (String[] arr : arrX){
            System.out.println('\n');
            for (String elem : arr){
                System.out.print(elem);
            }
        }
    }


}

