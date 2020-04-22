package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Villain extends Npc {
    Vector<Ability> abilities;
    public Villain() {
        Random rnd = new Random();
        Npc v = VillainList.villainPool.get(rnd.nextInt(VillainList.villainPool.size()));
        super.setName(v.getName());
        super.health = v.getHealth();
        abilities = new Vector<>(v.getAbilities());
    }

    public Villain(String name, int health) {
        Random rnd = new Random();
        super.setName(name);
        super.health = health;
        abilities = new Vector<>();
        abilities.add(AbilityList.villainAbilities.get(rnd.nextInt(AbilityList.villainAbilities.size())));
    }

    @Override
    public Vector<Ability> getAbilities() {
        return abilities;
    }

    @Override
    public Npc spawnFrom() {
        return null;
    }

}
