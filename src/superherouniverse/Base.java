package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Base {
    private Vector<Npc> npcs;
    private NpcClass type;

    public Base(Vector<Npc> npcs, NpcClass type) {
        this.npcs = new Vector<>(npcs);
        this.type = type;
    }

    public Npc getRandomNpc() {
        Random rnd = new Random();
        return npcs.get(rnd.nextInt(npcs.size()));
    }

    public void removeNpc(Npc npc) {
        npcs.remove(npc);
    }

    public NpcClass getType() {
        return type;
    }

    public boolean isEmpty() {
        return npcs.isEmpty();
    }
}
