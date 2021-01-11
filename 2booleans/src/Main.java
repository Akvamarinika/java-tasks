
public class Main {
    public static void main(String[] args) {
        int milkAmount = 200; // ml
        int powderAmount = 5; // g
        int eggsCount = 4; // items
        int sugarAmount = 5; // g
        int oilAmount = 30; // ml
        int appleCount = 8;
        String str = "You can cook ";

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        if (powderAmount >= 400 && sugarAmount >= 10 && milkAmount >= 1000 && oilAmount >= 30)
            System.out.println(str + "Pancakes");
        //milk - 300 ml, powder - 5 g, eggs - 5
        else if (milkAmount >= 300 && powderAmount >= 5 && eggsCount >= 5) {
            System.out.println(str + "Omelette");
         //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
        } else if (appleCount >= 3 && milkAmount >= 100 && eggsCount >= 4) {
            System.out.println(str + "Apple pie");
        } else {
            System.out.println("Insufficient amount of food for cooking!");
        }

    }
}