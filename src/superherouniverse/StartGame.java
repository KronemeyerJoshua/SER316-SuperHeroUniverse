package superherouniverse;

import java.util.Vector;

public class StartGame {
    public static void main(String[] args) {
        Vector<Npc> heroes = new Vector<>();
        Vector<Npc> villains = new Vector<>();
        for (int i = 0; i < 5; i++) {
            heroes.add(Npc.create(NpcClass.HERO));
            villains.add(Npc.create(NpcClass.VILLAIN));
        }

        Combat combat = new Combat(heroes, villains);
        boolean b = combat.runCombatSim();

        if (b) {
            System.out.println("Heroes win!");
        }
        else {
            System.out.println("Villians Win!");
        }
    }
}
