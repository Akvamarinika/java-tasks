import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*TODO 1.	Напишите тесты на все методы класса RouteCalculator в проекте SPBMetro.
    2.	С помощью тестов и отладки исправьте ошибку, которую вы найдёте в проекте SPBMetro в классе RouteCalculator.
*/

public class RouteCalculatorTest extends TestCase {
    List<Station> route;
    StationIndex stationIndex;
    RouteCalculator calculator;
    Line line1;
    Line line2;
    Line line3;
    Station station11;
    Station station12;
    Station station13;
    Station station21;
    Station station22;
    Station station23;
    Station station31;
    Station station32;

    @Override
    protected void setUp() {
        route = new ArrayList<>();
        stationIndex = new StationIndex();

        line1 = new Line(1, "First");
        line2 = new Line(2, "Second");
        line3 = new Line(3, "Third");

        station11 = new Station("Лесная", line1);
        station12 = new Station("Балтийская", line1);
        station13 = new Station("Академическая", line1);
        station21 = new Station("Озерки", line2);
        station22 = new Station("Звёздная", line2);
        station23 = new Station("Чёрная речка", line2);
        station31 = new Station("Садовая", line3);
        station32 = new Station("Спасская", line3);

        line1.addStation(station11);
        line1.addStation(station12);
        line1.addStation(station13);
        line2.addStation(station21);
        line2.addStation(station22);
        line2.addStation(station23);
        line3.addStation(station31);
        line3.addStation(station32);


        route.add(station11);
        route.add(station12);
        route.add(station13);
        route.add(station21);
        route.add(station22);
        route.add(station23);
        route.add(station31);
        route.add(station32);

      /*  stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);
        stationIndex.addStation(station11);
        stationIndex.addStation(station12);
        stationIndex.addStation(station13);
        stationIndex.addStation(station21);
        stationIndex.addStation(station22);
        stationIndex.addStation(station23);
        stationIndex.addStation(station31);
        stationIndex.addStation(station32);
*/

        stationIndex.addConnection(Stream.of(station13, station21).collect(Collectors.toList()));
        stationIndex.addConnection(Stream.of(station23, station31).collect(Collectors.toList()));
        stationIndex.getConnectedStations(station12);
        stationIndex.getConnectedStations(station23);
        calculator = new RouteCalculator(stationIndex);



    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 19.5;
        assertEquals(expected, actual);
    }

    public void testGetShortestRouteDirectRoute(){
        List<Station> expectedList = Stream.of(station11, station12, station13).collect(Collectors.toList());
        List<Station> stations = calculator.getShortestRoute(station11, station13);
        assertEquals(3, stations.size());
        assertEquals(expectedList, stations);
    }

    public void testGetRouteWithOneConnection(){
        List<Station> expectedList = Stream.of(station11, station12, station13, station21, station22)
                .collect(Collectors.toList());
        List<Station> stations = calculator.getShortestRoute(station11, station22);
        assertEquals(5, stations.size());
        assertEquals(expectedList, stations);
    }

    public void testGetRouteWithTwoChange(){
        List<Station> expectedList = Stream.of(station11, station12, station13, station21, station22, station23, station31, station32)
                .collect(Collectors.toList());
        List<Station> stations = calculator.getShortestRoute(station11, station32);
        assertEquals(8, stations.size());
        assertEquals(expectedList, stations);
    }


}
