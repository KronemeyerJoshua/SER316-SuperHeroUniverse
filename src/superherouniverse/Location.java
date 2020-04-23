package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Location {
    private String name;
    private Vector<Base> bases;
    private boolean isCorrupted;
    private double encounterChance;

    /**
     * Constructor location.
     * Pulls a new random location from locationPool
     */
    public Location() {
        Random rnd = new Random();
        Location l = LocationList.locationPool.get(rnd.nextInt(LocationList.locationPool.size()));
        bases = new Vector<>();
        this.name = l.getName();
        this.isCorrupted = l.isCorrupted();
        this.encounterChance = l.getEncounterChance();
    }

    /**
     * Constructor for LocationList, setting up custom locations.
     * @param name Location name
     * @param isCorrupted Location is only villains
     * @param encounterChance Chance of fighting in the location
     */
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

    /**
     * isCorrupted implies only villains remain.
     * @return boolean value for isCorrupted
     */
    public boolean isCorrupted() {
        return isCorrupted;
    }

    public void setCorrupted(boolean corrupted) {
        isCorrupted = corrupted;
    }

    /**
     * Adds a base to the location.
     * Maximum of 2 bases can be at any given location
     * @param b The base object
     * @return Boolean successfully added or not
     */
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

    /**
     * Gets the base object of Villains.
     * @return The Base object of villains
     */
    public Base getVillainBase() {
        for (Base b : bases) {
            if (b.getType() == NpcClass.VILLAIN) {
                return b;
            }
        }
        return null;
    }

    /**
     * Gets the base object of Heroes.
     * @return The Base object of Heroes
     */
    public Base getHeroBase() {
        for (Base b : bases) {
            if (b.getType() == NpcClass.HERO) {
                return b;
            }
        }
        return null;
    }
}
