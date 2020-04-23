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

        // Pull 5 random locations to use
        System.out.printf("Generating locations...%n");
        for (int i = 0; i < 5; i++) {
            locations.add(new Location());
        }

        // Generate 5 heroes/villains, put them in bases
        System.out.printf("Generating bases and putting people inside them...%n");
        for (Location loc : locations) {
            Vector<Npc> heroes = new Vector<>();
            Vector<Npc> villains = new Vector<>();
            for (int j = 0; j < 5; j++) {
                heroes.add(Npc.create(NpcClass.HERO));
                villains.add(Npc.create(NpcClass.VILLAIN));
            }
            // Put our bases in our locations
            loc.addBase(new Base(heroes, NpcClass.HERO));
            loc.addBase(new Base(villains, NpcClass.VILLAIN));
        }

        // Need random to generate number for encounter chance
        Random rnd = new Random();
        Combat combat = new Combat();

        // We remove locations when they've fallen/enlightened
        while (locations.size() > 0) {
            // Iterate throuigh each location
            for (Location location : locations) {
                System.out.printf("Checking in on %s%n", location.getName());

                // If random rolls within the encounter chance, hero has met villain
                if (rnd.nextDouble() <= location.getEncounterChance()) {
                    Npc villain = location.getVillainBase().getRandomNpc();
                    Npc hero = location.getHeroBase().getRandomNpc();

                    System.out.printf("Hero %s is battling Villain %s%n",
                            hero.getName(), villain.getName());
                    combat.replaceNpcs(hero, villain);
                    boolean b = combat.runCombatSim();

                    // If b is true, the hero has won
                    if (b) {
                        // Get first ability of villain and add it to hero
                        hero.addAbility(villain.getAbilities().get(0));
                        System.out.printf("%s triumphed and obtained the power %s%n",
                                hero.getName(), villain.getAbilities().get(0).getName());
                        location.getVillainBase().removeNpc(villain);
                    } else {
                        // Get first ability of hero and add it to villain
                        villain.addAbility(hero.getAbilities().get(0));
                        System.out.printf("%s triumphed and obtained the power %s%n",
                                villain.getName(), hero.getAbilities().get(0).getName());
                        location.getHeroBase().removeNpc(hero);
                    }

                    // Check to see if any locations have
                    // fallen or been enlightened
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

            // If location has fallen, remove it
            for (Location location : fallenLocations) {
                locations.remove(location);
            }

            // If location has been enlightened, remove it
            for (Location location : enlightenedLocations) {
                locations.remove(location);
            }
        }

        // All locations have been battled for
        // Determine ending
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
