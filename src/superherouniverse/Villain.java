package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Villain extends Npc {
    Vector<Ability> abilities;
    public Villain() {
        Random rnd = new Random();
        abilities = new Vector<>();
        abilities.add(AbilityList.villainAbilities.get(rnd.nextInt(AbilityList.villainAbilities.size())));
        super.setName("VILLAIN");
        super.health = 100;
    }

    @Override
    public Vector<Ability> getAbilities() {
        return abilities;
    }
}
