import java.util.Scanner;
public class Age {
    public static  void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.println("Введите возраст Васи: ");
        int vasyaAge = input.nextInt();
        System.out.println("Введите возраст Кати: ");
        int katyaAge = input.nextInt();
        System.out.println("Введите возраст Миши: ");
        int mishaAge = input.nextInt();

        int min;
        int middle;
        int max;

        if (vasyaAge > katyaAge && vasyaAge > mishaAge){
            max = vasyaAge;
            if (katyaAge > mishaAge){
                middle = katyaAge;
                min = mishaAge;
            } else {
                middle = mishaAge;
                min = katyaAge;
            }
        } else if (vasyaAge < katyaAge && vasyaAge < mishaAge){
            min = vasyaAge;
            if (katyaAge > mishaAge){
                max = katyaAge;
                middle = mishaAge;
            }else {
                max = mishaAge;
                middle = katyaAge;
            }
        }else {
            middle = vasyaAge;
            if (katyaAge > mishaAge){
                max = katyaAge;
                min = mishaAge;
            } else {
                max = mishaAge;
                min = katyaAge;
            }
        }

        System.out.println("Min age: " + min);
        System.out.println("Middle age: " + middle);
        System.out.println("Max age: " + max);
    }
}
