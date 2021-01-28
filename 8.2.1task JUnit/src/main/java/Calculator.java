public class Calculator {
    //private static int numA;
    public static int add(int numA, int numB){
        return  numA + numB;
    }

    public static double add(double numA, double numB){
        return numA + numB;
    }

    public static int subtraction(int numA, int numB){
        return  numA - numB;
    }

    public static double subtraction(double numA, double numB){
        return numA - numB;
    }


    public static int multiplication(int numA, int numB){
        return  numA * numB;
    }

    public static double multiplication(double numA, double numB){
        return numA * numB;
    }

    public static int division(int numA, int numB){
        try {
            return  numA / numB;
        } catch (ArithmeticException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static double division(double numA, double numB){
        return numA / numB;
    }

    public static int pow(int numA, int power){
        int result = 1;
        for (int i = 1; i <= power; i++){
            result *= numA;
        }
        return  result;
    }

}

