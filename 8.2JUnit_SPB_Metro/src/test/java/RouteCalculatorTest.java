import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    Station station33;

    @Override
    protected void setUp() throws Exception {
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
        station33 = new Station("Спортивная", line3);

        route.add(station11);
        route.add(station12);
        route.add(station13);
        route.add(station21);
        route.add(station22);
        route.add(station23);
        route.add(station31);
        route.add(station32);
        route.add(station33);

        stationIndex.addLine(line1);
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
        stationIndex.addStation(station33);

        stationIndex.addConnection(Stream.of(station13, station21).collect(Collectors.toList()));
        stationIndex.addConnection(Stream.of(station23, station31).collect(Collectors.toList()));
        stationIndex.getConnectedStations(station13);
        stationIndex.getConnectedStations(station23);
        calculator = new RouteCalculator(stationIndex);



    }

    public void testCalculateDuration(){
        double actual = RouteCalculator.calculateDuration(route);
        double expected = 22.0;
        assertEquals(expected, actual);
    }

    public void testGetShortestRoute(){

        List<Station> stations = calculator.getShortestRoute(station11, station13);
        assertEquals(3, stations.size());
    }

    public void testGetShortestRoute2(){

        List<Station> stations = calculator.getShortestRoute(station11, station13);
        assertEquals(3, stations.size());
    }

    public void testGetRouteWithTwoConnections(){

        List<Station> stations = calculator.getShortestRoute(station11, station13);
        assertEquals(3, stations.size());
    }
}
