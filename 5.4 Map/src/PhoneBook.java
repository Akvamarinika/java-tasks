import java.util.*;

/*TODO
*  1. Напишите программу, которая будет работать как телефонная книга:
    •	Если пишем новое имя, программа просит ввести номер телефона и запоминает его. Если новый номер телефона — просит ввести имя и также запоминает.
    •	Если вводим существующее имя или номер телефона, программа выводит всю информацию о контакте.
    •	При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.
   2. Определяйте имя и телефон с помощью регулярных выражений.
*/
public class PhoneBook {
    private static Map<String, Set<String> > name2phone = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String PHONE_REGIX = "^(\\+7|7|8)\\s*[-(]*\\d{3}[-)]*\\s*\\d{3}[-\\s]*\\d{2}[-\\s]*\\d{2}$";
    private static final String NAME_REGIX = "[a-zA-z]+\\s?[a-zA-z]*";
    public static void main(String[] args){
        fillWithTestData();
        String input = scanner.nextLine();
        if (input.equals("LIST")){
            printPhoneBook();
        }else if(input.matches(NAME_REGIX)){
            addNewName(input);
        }else if(input.matches(PHONE_REGIX)){
            addNewPhone(input);
        }


    }

    private static void addNewName(String inputUser){
        StringBuilder builder = new StringBuilder(inputUser.toLowerCase());
        String symbol = Character.toString(Character.toUpperCase(inputUser.charAt(0)));
        builder.replace(0,1, symbol);
        if (name2phone.containsKey(inputUser)){
            printContact(inputUser);
        }else {
            System.out.println("Input tel. contact " + inputUser + ": ");

            if (scanner.nextLine().matches(PHONE_REGIX)){

            }

        }
    }

    private static void addNewPhone(String inputUser){
        boolean flag = false;
        String phone = inputUser.replaceAll("[\\s-()]*","");
        phone = phone.replaceAll("(\\+7|7)*","8");
        StringBuilder builderPhone = new StringBuilder(phone);
        builderPhone.insert(1,"(");
        builderPhone.insert(5,")");
        builderPhone.insert(9,"-");
        builderPhone.insert(12,"-");
        for (Map.Entry entry : name2phone.entrySet()){
            Set set = entry.getValue();
            for (Set arr : entry.getValue()){
                if (arr.contains(builderPhone.toString())){
                    flag = true;
                    break;
                }
            }
        }

        if (flag){
            printContact(inputUser);////
        }
        name2phone.containsValue();
        if (builderPhone.toString()){

        }
    }
    private static void printContact(String key){
        System.out.printf("\nContact %s: \ntel.: %s", key, name2phone.get(key));
    }
    private static void printPhoneBook(){
        for (String key : name2phone.keySet()){
            System.out.printf("\nName %s: %s", key, name2phone.get(key));
        }
    }

    private static void checkSet(String key, String value){
        if (!name2phone.containsKey(key)){
            name2phone.put(key, new HashSet<String>());
        }
        name2phone.get(key).add(value);
    }

    private static void fillWithTestData(){
        checkSet("Amy", "8(950)128-45-84");
        checkSet("Victor", "8(914)333-11-11");
        checkSet("Dave", "8(924)000-12-34");
        checkSet("Pavel", "8(914)914-00-00");
        checkSet("Alex", "8(950)111-22-22");
        checkSet("Victor", "8(914)333-11-11");
       // name2phone.put("Alex", "8(950)111-22-22");
    }

}
