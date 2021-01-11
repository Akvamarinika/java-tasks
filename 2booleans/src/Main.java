import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Введите кол-во молока (ml): ");
        int milkAmount = input.nextInt(); // ml
        System.out.print("Введите кол-во муки (g): ");
        int powderAmount = input.nextInt(); // g
        System.out.print("Введите кол-во яиц (шт.): ");
        int eggsCount = input.nextInt(); // items
        System.out.print("Введите кол-во сахара (g): ");
        int sugarAmount = input.nextInt(); // g
        System.out.print("Введите кол-во масла (ml): ");
        int oilAmount = input.nextInt(); // ml
        System.out.print("Введите кол-во яблок (шт.): ");
        int appleCount = input.nextInt();
        boolean canCookRecipe = false;
        String str = "You can cook ";

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        if (powderAmount >= 400 && sugarAmount >= 10 && milkAmount >= 1000 && oilAmount >= 30){
            System.out.println(str + "Pancakes");
            canCookRecipe = true;
        }
        //milk - 300 ml, powder - 5 g, eggs - 5
        if (milkAmount >= 300 && powderAmount >= 5 && eggsCount >= 5) {
            System.out.println(str + "Omelette");
            canCookRecipe = true;
         //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
        }
        if (appleCount >= 3 && milkAmount >= 100 && powderAmount >= 300 && eggsCount >= 4) {
            System.out.println(str + "Apple pie");
            canCookRecipe = true;
        }

       if (!canCookRecipe){
            System.out.println("Insufficient amount of food for cooking!");
        }

    }
}