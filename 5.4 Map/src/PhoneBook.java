import java.util.*;

/*TODO
*  1. Напишите программу, которая будет работать как телефонная книга:
    •	Если пишем новое имя, программа просит ввести номер телефона и запоминает его. Если новый номер телефона — просит ввести имя и также запоминает.
    •	Если вводим существующее имя или номер телефона, программа выводит всю информацию о контакте.
    •	При вводе команды LIST программа печатает в консоль список всех абонентов в алфавитном порядке с номерами.
   2. Определяйте имя и телефон с помощью регулярных выражений.
*/
public class PhoneBook {
    private static Map<String, Set<String> > name2phone = new TreeMap<>();
    private static Scanner scanner = new Scanner(System.in);
    private static final String PHONE_REGIX = "^(\\+7|7|8)\\s*[-(]*\\d{3}[-)]*\\s*\\d{3}[-\\s]*\\d{2}[-\\s]*\\d{2}$";
    private static final String NAME_REGIX = "[a-zA-z]+\\s?[a-zA-z]*";
    public static void main(String[] args){
        fillWithTestData();
        while (true) {
            System.out.println("\nДля вывода всех контактов используйте команду LIST. \nВведите тел./имя контакта: ");
            String input = scanner.nextLine();
            if (input.equals("LIST")) {
                printPhoneBook();
            } else if (input.matches(NAME_REGIX)) {
                addNewName(input);
            } else if (input.matches(PHONE_REGIX)) {
                addNewPhone(input);
            }
        }
    }

    private static void addNewName(String inputName){
        inputName = nameFormat(inputName);
        String inputPhone;
        if (name2phone.containsKey(inputName)){
            printContact(inputName);
        }else {
            System.out.println("Введите тел. для контакта " + inputName + ": ");
            inputPhone = scanner.nextLine();
            if (inputPhone.matches(PHONE_REGIX)){
                inputPhone = numberFormat(inputPhone);
                addNewSet(inputName,inputPhone);
            }else {
                System.out.println("Ошибка: Неверно введен тел.!");
            }

        }
    }

    private static void addNewPhone(String inputUser){
        boolean flag = false;
        String formatPhone = numberFormat(inputUser);
        for (String key : name2phone.keySet()){
            if(name2phone.get(key).contains(formatPhone)){ // Set name2phone.get(key).
                printContact(key);
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("Введите имя контакта для тел. " + formatPhone +": ");
            String inputName = scanner.nextLine();
            if (inputName.matches(NAME_REGIX)){
                inputName = nameFormat(inputName);
                addNewSet(inputName,formatPhone);
            }else {
                System.out.println("Ошибка: Неверно введено имя контакта!");
            }
        }

    }

    private static String nameFormat(String inputUser) {
        StringBuilder builder = new StringBuilder(inputUser.trim().toLowerCase());
        String symbol = Character.toString(Character.toUpperCase(inputUser.charAt(0)));
        builder.replace(0, 1, symbol);
        String symbolSurname = Character.toString(Character.toUpperCase(builder.charAt(builder.indexOf(" ") + 1)));
        builder.replace(builder.indexOf(" ") + 1,builder.indexOf(" ") + 2, symbolSurname);
        return builder.toString();
    }

    private static String numberFormat(String inputUser){
        String phone = inputUser.replaceAll("[\\s-()]*","");
        phone = phone.replaceAll("^(\\+7|7)","8");
        StringBuilder builderPhone = new StringBuilder(phone);
        builderPhone.insert(1,"(");
        builderPhone.insert(5,")");
        builderPhone.insert(9,"-");
        builderPhone.insert(12,"-");
        return builderPhone.toString();
    }

    private static void printContact(String key){
        System.out.printf("\nContact %s: \ntel.: %s", key, name2phone.get(key));
    }
    private static void printPhoneBook(){
        for (String key : name2phone.keySet()){
            System.out.printf("\nName %s: %s", key, name2phone.get(key));
        }
    }

    private static void addNewSet(String key, String value){
        if (!name2phone.containsKey(key)){
            name2phone.put(key, new HashSet<String>());
        }
        name2phone.get(key).add(value);
    }

    private static void fillWithTestData(){
        addNewSet("Amy", "8(950)128-45-84");
        addNewSet("Victor", "8(914)333-11-11");
        addNewSet("Dave", "8(924)000-12-34");
        addNewSet("Pavel", "8(914)914-00-00");
        addNewSet("Alex", "8(950)111-22-22");
        addNewSet("Victor", "8(914)333-11-11");
       // name2phone.put("Alex", "8(950)111-22-22");
    }

}
