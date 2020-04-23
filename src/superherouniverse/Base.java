package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Base {
    Vector<Npc> npcs;
    NpcClass type;

    public Base(Vector<Npc> npcs, NpcClass type) {
        this.npcs = new Vector<>(npcs);
        this.type = type;
    }

    public boolean addNpc(Npc npc) {
        boolean success = false;
        if (npcs.size() < 5) {
            npcs.add(npc);
            success = true;
        }
        return success;
    }

    public Npc getRandomNpc() {
        Random rnd = new Random();
        return npcs.get(rnd.nextInt(npcs.size()));
    }
}
