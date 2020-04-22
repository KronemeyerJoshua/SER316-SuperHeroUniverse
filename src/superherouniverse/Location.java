package superherouniverse;

import java.util.Vector;

public class Location {
    private String name;
    private Vector<Npc> npcs;
    private boolean isCorrupted;

    public Location(String name, Vector<Npc> npcs, boolean isCorrupted) {
        this.name = name;
        this.npcs = npcs;
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

    public Vector<Npc> getNpcs() {
        return npcs;
    }

    public void setNpcs(Vector<Npc> npcs) {
        this.npcs = npcs;
    }

    public void addNpc(Npc npc) {
        npcs.add(npc);
    }

    public boolean isCorrupted() {
        return isCorrupted;
    }

    public void setCorrupted(boolean corrupted) {
        isCorrupted = corrupted;
    }
}
