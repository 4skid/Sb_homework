import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


public class RouteCalculatorTest extends TestCase {
    StationIndex stationIndex = new StationIndex();
    RouteCalculator routeCalculator = new RouteCalculator(stationIndex);

@Override
    public void setUp() {
        Line line1 = new Line(1,"Первая линия");
        Line line2 = new Line(2,"Вторая линия");
        Line line3 = new Line(3,"Третья линия");

        ArrayList<Station> stations = new ArrayList<>();

        Station station1_1 = new Station("Лесная",line1);
        Station station1_2 = new Station("Кедровая",line1);
        Station station1_3 = new Station("Ореховая",line1);
        stations.add(station1_1);
        stations.add(station1_2);
        stations.add(station1_3);

        Station station2_1 = new Station("Клубничная",line2);
        Station station2_2 = new Station("Вишневая",line2);
        Station station2_3 = new Station("Апельсиновая",line2);
        stations.add(station2_1);
        stations.add(station2_2);
        stations.add(station2_3);

        Station station3_1 = new Station("Правды",line3);
        Station station3_2 = new Station("Доблести",line3);
        Station station3_3 = new Station("Отваги",line3);
        stations.add(station3_1);
        stations.add(station3_2);
        stations.add(station3_3);

        line1.addStation(station1_1);
        line1.addStation(station1_2);
        line1.addStation(station1_3);

        line2.addStation(station2_1);
        line2.addStation(station2_2);
        line2.addStation(station2_3);

        line3.addStation(station3_1);
        line3.addStation(station3_2);
        line3.addStation(station3_3);

        stationIndex.addLine(line1);
        stationIndex.addLine(line2);
        stationIndex.addLine(line3);

        stationIndex.addStation(station1_1);
        stationIndex.addStation(station1_2);
        stationIndex.addStation(station1_3);
        stationIndex.addStation(station2_1);
        stationIndex.addStation(station2_2);
        stationIndex.addStation(station2_3);
        stationIndex.addStation(station3_1);
        stationIndex.addStation(station3_2);
        stationIndex.addStation(station3_3);

        List<Station> line1_line2 = new ArrayList<>();
        line1_line2.add(station1_1);
        line1_line2.add(station2_1);
        stationIndex.addConnection(line1_line2);

        List<Station> line2_line3 = new ArrayList<>();
        line2_line3.add(station2_2);
        line2_line3.add(station3_1);
        stationIndex.addConnection(line2_line3);
    }

    public void testGetShortestRoute () {
        List<Station> actual = routeCalculator.getShortestRoute(
                stationIndex.getStation("Лесная",1),
                stationIndex.getStation("Ореховая",1));
        List<Station> expected = new ArrayList<>();
        expected.add(new Station("Лесная", new Line(1,"Первая линия")));
        expected.add(new Station("Кедровая", new Line(1,"Первая линия")));
        expected.add(new Station("Ореховая", new Line(1,"Первая линия")));
        assertEquals(expected,actual);
    }

    public void testCalculateDuration() {
        List<Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("Лесная",1));
        route.add(stationIndex.getStation("Клубничная",2));
        route.add(stationIndex.getStation("Вишневая",2));
        route.add(stationIndex.getStation("Правды", 3));
        route.add(stationIndex.getStation("Доблести", 3));

        double actual = RouteCalculator.calculateDuration(route);
        double expected = 3.5 + 2.5 + 3.5 + 2.5;

        assertEquals(expected,actual);

    }

    public void testGetRouteOnTheLine() {
        List<Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("Лесная", 1));
        route.add(stationIndex.getStation("Кедровая", 1));
        route.add(stationIndex.getStation("Ореховая", 1));

        List<Station> actualRoute = routeCalculator.getShortestRoute(
                stationIndex.getStation("Лесная"),
                stationIndex.getStation("Ореховая"));

        assertEquals(route,actualRoute);
    }

    public void testGetRouteWithOneConnection() {
        List<Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("Ореховая", 1));
        route.add(stationIndex.getStation("Кедровая", 1));
        route.add(stationIndex.getStation("Лесная", 1));
        route.add(stationIndex.getStation("Клубничная",2));
        route.add(stationIndex.getStation("Вишневая",2));
        route.add(stationIndex.getStation("Апельсиновая",2));

        List<Station> actualRoute = routeCalculator.getShortestRoute(
                stationIndex.getStation("Ореховая"),
                stationIndex.getStation("Апельсиновая"));

        assertEquals(route,actualRoute);
    }

    public void testGetRouteViaConnectedLine() {
        List<Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("Лесная", 1));
        route.add(stationIndex.getStation("Кедровая", 1));
        route.add(stationIndex.getStation("Ореховая", 1));

        List<Station> actualRoute = routeCalculator.getShortestRoute(
                stationIndex.getStation("Лесная"),
                stationIndex.getStation("Ореховая"));

        assertEquals(route,actualRoute);
    }

    public void testGetRouteWithTwoConnections() {
        List<Station> route = new ArrayList<>();
        route.add(stationIndex.getStation("Ореховая", 1));
        route.add(stationIndex.getStation("Кедровая", 1));
        route.add(stationIndex.getStation("Лесная", 1));
        route.add(stationIndex.getStation("Клубничная",2));
        route.add(stationIndex.getStation("Вишневая",2));
        route.add(stationIndex.getStation("Правды", 3));
        route.add(stationIndex.getStation("Доблести", 3));

        List<Station> actualRoute = routeCalculator.getShortestRoute(
                stationIndex.getStation("Ореховая"),
                stationIndex.getStation("Доблести"));

        assertEquals(route,actualRoute);

    }
}
