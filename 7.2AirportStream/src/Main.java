import com.skillbox.airport.Airport;
import com.skillbox.airport.Flight;
import com.skillbox.airport.Terminal;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
/*TODO Распечатайте с помощью библиотеки airport.jar время вылета и модели самолётов, вылетающих в ближайшие два часа.*/

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, 2);
         Airport airport = Airport.getInstance();
        for (Terminal t : airport.getTerminals()) {
            System.out.println(t.getFlights());
        }
        airport.getTerminals().stream()
                .map(Terminal::getFlights)
                .flatMap(Collection::stream)
                .filter(flight -> flight.getType() == Flight.Type.ARRIVAL &&
                        flight.getDate().getTime() < calendar.getTime().getTime() &&
                        flight.getDate().getTime() > System.currentTimeMillis())
                .forEach(flight -> System.out.println(flight.getAircraft().getModel() + " " + new SimpleDateFormat("HH:mm").format(flight.getDate())));
    }
}
