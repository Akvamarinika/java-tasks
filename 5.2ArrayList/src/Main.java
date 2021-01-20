/*TODO: Разработайте список дел, который управляется командами в консоли. Команды: LIST, ADD, EDIT, DELETE.
    Принцип работы команд:
    •	LIST — выводит дела с их порядковыми номерами;
    •	ADD — добавляет дело в конец списка или дело на определённое место, сдвигая остальные дела вперёд, если указать номер;
    •	EDIT — заменяет дело с указанным номером;
    •	DELETE — удаляет.
*/
import  java.util.Scanner;
public class Main {
    public  static  void  main(String[] args){
        ArrayListToDo toDo = ArrayListToDo.getInstance();
        toDo.todoAdd("Первое дело");
        toDo.todoAdd("Второе дело");
        toDo.todoAdd("Третье дело");
        toDo.todoAdd(0, "Нулевое дело");
        while (true){
            System.out.println("Введите команду: ");
            String input = new Scanner(System.in).nextLine();
            toDo.commandProcessing(input);

        }

    }
}
