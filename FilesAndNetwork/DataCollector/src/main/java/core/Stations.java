package core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Stations {
    private String name;
    private String line;
    private String date;
    private String depth;
    private boolean hasConnection;

    public Stations(String name) {
        this.name = name;
    }

    public void setHasConnection(boolean hasConnection) {
        this.hasConnection = hasConnection;
    }

    public boolean equalsName(Stations obj) {
        return this.getName().equals(obj.getName());
    }
}
