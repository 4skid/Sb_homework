package json;

import core.Connections;
import core.Lines;
import lombok.Getter;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

@Getter
public class JsonCreateMap {
    private final Map<String, ArrayList<String>> stations = new LinkedHashMap<>();
    private final ArrayList<Lines> lines = new ArrayList<>();
    private final ArrayList<Connections> connections = new ArrayList<>();

    public void setConnections(String name, String stationNumber) {
        Connections connections = new Connections(name, stationNumber);
        this.connections.add(connections);
    }

    public void setLines(String number, String name) {
        Lines line = new Lines(number, name);
        this.lines.add(line);
    }

    public void setStations(String number, ArrayList<String> stations) {
        this.stations.put(number, stations);
    }
}
