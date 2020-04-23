package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class StartGame {
    public static void main(String[] args)
    {
        Vector<Location> locations = new Vector<>();

        System.out.printf("Generating locations...%n");
        for (int i = 0; i < 5; i++) {
            locations.add(new Location());
        }

        System.out.printf("Generating bases and putting people inside them...%n");
        for (Location value : locations) {
            Vector<Npc> heroes = new Vector<>();
            Vector<Npc> villains = new Vector<>();
            for (int j = 0; j < 5; j++) {
                heroes.add(Npc.create(NpcClass.HERO));
                villains.add(Npc.create(NpcClass.VILLAIN));
            }
            value.addBase(new Base(heroes, NpcClass.HERO));
            value.addBase(new Base(villains, NpcClass.VILLAIN));
        }

        Random rnd = new Random();
        Combat combat = new Combat();
        for (Location location : locations) {
            System.out.printf("Checking in on %s%n", location.getName());
            if (rnd.nextDouble() <= location.getEncounterChance()) {
                System.out.printf("Encounter happening %s%n", location.getName());
                Vector<Base> bases = location.getBases();
                Npc villain = location.getVillainBase().getRandomNpc();
                Npc hero = location.getHeroBase().getRandomNpc();
                combat.replaceNpcs(hero, villain);
                boolean b = combat.runCombatSim();
                if (b) {
                    System.out.println("hero win");
                }
            }
        }
    }

}
