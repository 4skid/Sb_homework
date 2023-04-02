package json;

import core.Stations;
import lombok.Getter;

import java.util.*;
@Getter
public class JsonCreateStations {
    private Set<Stations> stations = new TreeSet<>();

    public Object setStations(Set<Stations> stations) {
        this.stations = stations;
        return stations;
    }

    public Set<Stations> getStations() {
        return stations;
    }

}
