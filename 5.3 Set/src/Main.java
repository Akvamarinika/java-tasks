import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        EmailSet.checking("ADD abc@gmail.com");
        EmailSet.checking("add 123fv@mail.ru");
        EmailSet.checking("Add ygf_uh100@mail.ru");
        EmailSet.checking("add kggg@hotmail.com");
        EmailSet.checking("ADD kitkat123@yandex.ru");
        while (true){
            System.out.println("Введите команду: ");
            String input = new Scanner(System.in).nextLine();
            EmailSet.checking(input);
        }

    }
}
