import java.util.ArrayList;
public class ArrayListToDo {
    private static String command;
    private static int index;
    private static  String text;
    private static ArrayList<String> list = new ArrayList<>();
    private static ArrayListToDo todoList = new ArrayListToDo();
    private ArrayListToDo(){}
    public static ArrayListToDo getInstance(){
        return todoList;
    }

    public void commandProcessing(String str){
        str = str.trim();
        if (str.matches("^([a-zA-Z]+|[a-zA-Z]+\\s.+|[a-zA-Z]+\\s[0-9]+\\s.+)$")){
            if (str.matches("^HELP|help|Help$")){
                help();
            }else if(str.matches("^LIST|list|List$")){
                printList();
            }else if(str.matches("^(ADD|add|Add)\\s[^0-9\\s].+$")){
                text = str.substring(str.indexOf(" ")+1);
                todoAdd(text);
            }else if (str.matches("^(ADD|add|Add)\\s\\d+\\s.+$")){
                String[] arr = str.split("\\s+", 3);
                index = Integer.parseInt(arr[1]);
                text = arr[2];
                todoAdd(index,text);
            }else if(str.matches("^(EDIT|edit|Edit)\\s\\d+\\s.+$")){
                String[] arr = str.split("\\s+", 3);
                index = Integer.parseInt(arr[1]);
                text = arr[2];
                edit(index, text);
            }else if(str.matches("^(DELETE|delete|Delete)\\s\\d+$")){
                index = Integer.parseInt(str.substring(str.indexOf(" ")+1));
                delete(index);
            } else if(str.matches("^EXIT|exit|Exit$")){
                System.out.println("Выход из программы выполнен");
                System.exit(0);
            }

        } else {
            System.out.println("Неверно введена команда!");
            help();
        }

    }

    public void todoAdd(int idx, String elem){
        if (list.size() < idx){
            todoAdd(elem);
        }else {
            list.add(idx, elem);
        }
    }

    public void todoAdd(String elem){
        list.add(elem);
    }

    public void edit(int idx, String elem){
        if (idx < list.size()-1){
            list.set(idx, elem);
        }else{
            System.out.println("Неверный номер дела!");
        }

    }

    public void delete(int idx){
        if (idx < list.size()-1){
            list.remove(idx);
        }else{
            System.out.println("Неверный номер дела!");
        }
    }


    public void printList(){
        if (!list.isEmpty()){
            for (int i = 0; i < list.size(); i++){
                System.out.println(i + " " +list.get(i));
            }
        }else{
            System.out.println("Ваш список дел пуст!");
        }
    }

    public void help(){
        System.out.println("Доступные команды:");
        System.out.println("LIST - вывести список дел");
        System.out.println("ADD название дела - доб. новое дело в конец списка");
        System.out.println("ADD <номер дела> <название дела> - добавить новое дело на место под №");
        System.out.println("EDIT <номер дела> <изменить название дела> - ред. дело под №");
        System.out.println("DELETE <номер дела> - удалить дело под №");
    }
}
