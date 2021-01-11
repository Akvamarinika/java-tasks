import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args){
        Date date = new Date();
        System.out.println(date);
        DateFormat dateFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy");
        System.out.println(dateFormat.format(date));

        Calendar calendar = Calendar.getInstance();
        System.out.println("Date: " + calendar.getTime()); // obj date
        System.out.println("Millis: " + calendar.getTime().getTime());
        System.out.println(System.currentTimeMillis());
        calendar.add(Calendar.MONTH,4);
        calendar.add(Calendar.HOUR,2);
        System.out.println("сдвиг даты: " + dateFormat.format(calendar.getTime()));

        calendar = new GregorianCalendar();
        System.out.println("Date format: " + dateFormat.format(calendar.getTime()));
        calendar.set(2000, Calendar.FEBRUARY, 25,18,30);
        System.out.println("Set Date: " + dateFormat.format(calendar.getTime()));




    }
}
