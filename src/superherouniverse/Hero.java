package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Hero extends Npc {
    Vector<Ability> abilities;
    public Hero() {
        Random rnd = new Random();
        Npc h = HeroList.heroPool.get(rnd.nextInt(HeroList.heroPool.size()));
        super.setName(h.getName());
        super.health = h.getHealth();
        abilities = new Vector<>(h.getAbilities());
    }

    public Hero(String name, int health) {
        Random rnd = new Random();
        super.setName(name);
        super.health = health;
        abilities = new Vector<>();
        abilities.add(AbilityList.heroAbilities.get(rnd.nextInt(AbilityList.heroAbilities.size())));
    }

    @Override
    public Vector<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public Npc spawnFrom() {
        return null;
    }

    public String toString() {
        return String.format("Name: %s Health %s", super.getName(), super.getHealth());
    }
}
