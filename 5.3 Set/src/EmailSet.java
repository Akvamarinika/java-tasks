import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class EmailSet {
    private static Set<String> emails = new TreeSet<>();
    public EmailSet(){}

    public static Set<String> getEmails() {
        return emails;
    }

    private static void addEmail(String email) {
        EmailSet.emails.add(email);
    }

    public static void checking(String input){
        if (input.matches("^(ADD|add|Add)\\s+[\\dA-Za-z_]+@[\\dA-Za-z]+\\.[A-Za-z]{2,}$")){
            String mail = input.split("\\s+")[1].toLowerCase();
            if (!emails.contains(mail)){
                addEmail(mail);
            } else {
                System.out.println("Этот email уже есть в списке");
            }
        } else if (input.matches("^LIST|list|List$")){
            printList();
        }else if (input.matches("^EXIT|exit|Exit$")){
            System.exit(0);
        }else if (input.matches("^HELP|help|Help$")){
            getInfo();
        }else {
            System.out.println("Error input: ");
            getInfo();
        }

    }

    public static void printList(){
        System.out.println("emails Set: ");
        for (String email : emails){
            System.out.println(email);
        }
    }

    public static void getInfo(){
        System.out.println("•\tLIST — выводит список электронных адресов.\n" +
                "•\tADD <name@email.com> — добавляет email в множество.\n");
    }

}
