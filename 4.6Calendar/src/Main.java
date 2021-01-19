import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.DateFormat;
import java.util.Scanner;

/*TODO:
    Напишите программу, которая покажет прошедшие дни вашего рождения от нуля лет до текущего времени в формате: возраст, дата и день недели.
    Дату рождения задавайте используя три переменные:
    int day = 4;
    int month = 5;
    int year = 1995;
    Формат требуемого вывода:
    0 - 04.05.1995 - чт
    1 - 04.05.1995 - сб
    …
*/
public class Main {
    public  static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Введите день: ");
        int day = input.nextInt();
        System.out.print("Введите месяц: ");
        int month = input.nextInt();
        System.out.print("Введите год: ");
        int year = input.nextInt();
        birthday(day, month, year);
    }

    public  static void birthday(int day, int month, int year){
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy - EE");
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);
        calendar.set(year,month-1,day);
        for (int i = 0; i<= currentYear - year; i++){
            System.out.println(i + " - " + dateFormat.format(calendar.getTime()));
            calendar.add(Calendar.YEAR, 1);

        }

    }
}
