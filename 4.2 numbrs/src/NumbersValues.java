/*
TODO:
    распечатать в консоль минимальные отрицательные и максимальные положительные значения всех типов чисел
*/
public class NumbersValues {
    public  static  void main(String[] args){
        System.out.println("Byte min value: " + Byte.MIN_VALUE);
        System.out.println("Byte max value: " + Byte.MAX_VALUE + '\n');

        System.out.println("Short min value: " + Short.MIN_VALUE);
        System.out.println("Short max value: " + Short.MAX_VALUE  + '\n');

        System.out.println("Int min value: " + Integer.MIN_VALUE);
        System.out.println("Int max value: " + Integer.MAX_VALUE  + '\n');

        System.out.println("Long min value: " + Long.MIN_VALUE);
        System.out.println("Long max value: " + Long.MAX_VALUE  + '\n');

        System.out.println("Float min value: " + Float.MIN_VALUE);
        System.out.println("Float max value: " + Float.MAX_VALUE  + '\n');

        System.out.println("Double min value: " + Double.MIN_VALUE);
        System.out.println("Double max value: " + Double.MAX_VALUE  + '\n');
    }
}
