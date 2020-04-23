package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Hero extends Npc {
    /**
     * Hero constructor.
     * Pulls a hero from the heroPool in heroList
     */
    public Hero() {
        Random rnd = new Random();
        Npc h = HeroList.heroPool.get(rnd.nextInt(HeroList.heroPool.size()));
        super.setName(h.getName());
        super.health = h.getHealth();
        abilities = new Vector<>(h.getAbilities());
    }

    /**
     * Allows custom name and health to be set.
     * via hero constructor
     * @param name Hero name
     * @param health Hero Health
     */
    public Hero(String name, int health) {
        super.setName(name);
        super.health = health;
        abilities = new Vector<>();
        Random rnd = new Random();
        abilities.add(AbilityList.heroAbilities.get(rnd.nextInt(AbilityList.heroAbilities.size())));
    }

    @Override
    public Vector<Ability> getAbilities() {
        return abilities;
    }

    public String toString() {
        return String.format("Name: %s Health %s", super.getName(), super.getHealth());
    }
}
