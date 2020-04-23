package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Villain extends Npc {
    /**
     * Constructor for Villain.
     * Pulls a random villain from villainPool
     */
    public Villain() {
        Random rnd = new Random();
        Npc v = VillainList.villainPool.get(rnd.nextInt(VillainList.villainPool.size()));
        super.setName(v.getName());
        super.health = v.getHealth();
        abilities = new Vector<>(v.getAbilities());
    }

    /**
     * Constructor for Villain.
     * Sets up name and health, used in villainList
     * @param name Villains Name
     * @param health Villains Health
     */
    public Villain(String name, int health) {
        super.setName(name);
        super.health = health;
        abilities = new Vector<>();
        Random rnd = new Random();
        abilities.add(AbilityList.villainAbilities.get(
                rnd.nextInt(AbilityList.villainAbilities.size())));
    }

    @Override
    public Vector<Ability> getAbilities() {
        return abilities;
    }

}
