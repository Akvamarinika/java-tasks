public class Main {
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8};
        try {
            System.out.println(array[8]);
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Данный элемент массива не существует!");
        }
        System.out.println(array[7]);
    }
}
