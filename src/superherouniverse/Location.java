package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Location {
    private String name;
    private Vector<Base> bases;
    private boolean isCorrupted;
    private double encounterChance;

    public Location() {
        Random rnd = new Random();
        Location l = LocationList.locationPool.get(rnd.nextInt(LocationList.locationPool.size()));
        bases = new Vector<>();
        this.name = l.getName();
        this.isCorrupted = l.isCorrupted();
        this.encounterChance = l.getEncounterChance();
    }

    public Location(String name, Vector<Base> bases, boolean isCorrupted) {
        this.name = name;
        this.bases = new Vector<>(bases);
        this.isCorrupted = isCorrupted;
    }

    public Location(String name, boolean isCorrupted, double encounterChance) {
        this.name = name;
        this.isCorrupted = isCorrupted;
        this.encounterChance = encounterChance;
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

    public boolean addBase(Base b) {
        boolean success = false;
        if (bases.size() < 2) {
            bases.add(b);
            success = true;
        }
        return success;
    }

    public double getEncounterChance() {
        return encounterChance;
    }

    public Base getVillainBase() {
        for (Base b : bases) {
            if (b.type == NpcClass.VILLAIN)
                return b;
        }
        return null;
    }

    public Base getHeroBase() {
        for (Base b : bases) {
            if (b.type == NpcClass.HERO)
                return b;
        }
        return null;
    }
}
