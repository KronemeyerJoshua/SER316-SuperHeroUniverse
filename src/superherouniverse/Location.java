package superherouniverse;

import java.util.Vector;

public class Location {
    private String name;
    private Vector<Base> bases;
    private boolean isCorrupted;

    public Location(String name, Vector<Base> bases, boolean isCorrupted) {
        this.name = name;
        this.bases = new Vector<>(bases);
        this.isCorrupted = isCorrupted;
    }

    public Location(String name, boolean isCorrupted) {
        this.name = name;
        this.isCorrupted = isCorrupted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCorrupted() {
        return isCorrupted;
    }

    public void setCorrupted(boolean corrupted) {
        isCorrupted = corrupted;
    }

    public Vector<Base> getBases() {
        return bases;
    }

    public void removeBase(Base b) {
        bases.remove(b);
    }
}
