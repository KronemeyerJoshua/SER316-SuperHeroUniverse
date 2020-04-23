package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class StartGame {
    /**
     * Main game loop/setup.
     * @param args Console args
     */
    public static void main(String[] args) {
        Vector<Location> locations = new Vector<>();
        Vector<Location> fallenLocations = new Vector<>();
        Vector<Location> enlightenedLocations = new Vector<>();

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

        while (locations.size() > 0) {
            for (Location location : locations) {
                System.out.printf("Checking in on %s%n", location.getName());
                if (rnd.nextDouble() <= location.getEncounterChance()) {
                    Npc villain = location.getVillainBase().getRandomNpc();
                    Npc hero = location.getHeroBase().getRandomNpc();

                    System.out.printf("Hero %s is battling Villain %s%n",
                            hero.getName(), villain.getName());
                    combat.replaceNpcs(hero, villain);
                    boolean b = combat.runCombatSim();

                    if (b) {
                        hero.addAbility(villain.getAbilities().get(0));
                        location.getVillainBase().removeNpc(villain);
                        System.out.printf("%s triumphed and obtained the power%n",
                                hero.getName());
                    } else {
                        villain.addAbility(hero.getAbilities().get(0));
                        location.getHeroBase().removeNpc(hero);
                        System.out.printf("%s triumphed and obtained the power%n",
                                villain.getName());
                    }

                    if (location.getHeroBase().isEmpty()) {
                        location.setCorrupted(true);
                        fallenLocations.add(location);
                    } else if (location.getVillainBase().isEmpty()) {
                        enlightenedLocations.add(location);
                    }
                } else {
                    System.out.printf("\tIt's quiet...%n");
                }
            }

            for (Location location : fallenLocations) {
                locations.remove(location);
            }

            for (Location location : enlightenedLocations) {
                locations.remove(location);
            }
        }

        if (fallenLocations.size() > enlightenedLocations.size()) {
            System.out.printf("And so the world turned to darkness as the majority"
                    + " of the planet is now ruled by villains.%n");
        } else if (fallenLocations.size() < enlightenedLocations.size()) {
            System.out.printf("And so the world reached a new age of enlightenment"
                    + " as the majority of the planet is now helped by heroes.%n");
        } else {
            System.out.printf("The war raged on for many years. Cities burned, "
                    + "innocent civilians dead, but there is no end in sight for the "
                    + "battle between heroes and villains.%n");
        }
    }

}
