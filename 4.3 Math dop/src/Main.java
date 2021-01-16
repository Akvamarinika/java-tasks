/*TODO: Вы доставляете гуманитарную помощь в ящиках одинакового размера.
   У вас есть грузовики и контейнеры. В каждый грузовик помещается максимум 12 контейнеров.
   В каждый контейнер — не более 27 ящиков. Ящики, контейнеры и грузовики пронумерованы.
    Напишите программу, которая распределит ящики по контейнерам и грузовикам
    в зависимости от их количества. Программа должна выводить необходимое
    для этого число грузовиков и контейнеров.
*/
public class Main {
    public  static  void main(String[] args){
        int sizetTruks = 12;
        int sizeContainer = 27;
        int countBoxes = 120;
        int truck = 1;
        int container = 1;

        System.out.println("Грузовик " + truck + ": ");
        System.out.println("\tКонтейнер " + container + ": ");
        for (int box = 1; box <= countBoxes; box++){
            if(container % sizetTruks == 0){
                truck++;
                System.out.println("Грузовик " + truck + ": ");
            }
            if (box % sizeContainer == 0){
                container++;
                System.out.println("\tКонтейнер " + container + ": ");
            }
            System.out.println("\t\tЯщик " + box);
        }
        System.out.println("Необходимо: \n" + "грузовиков — " + truck + " шт.\nконтейнеров — " + container + " шт.");
    }
}
