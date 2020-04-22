package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Hero extends Npc {
    Vector<Ability> abilities;
    public Hero() {
        Random rnd = new Random();
        abilities = new Vector<>();
        abilities.add(AbilityList.heroAbilities.get(rnd.nextInt(AbilityList.heroAbilities.size())));
        super.setName("HERO");
        super.health = 100;
    }

    @Override
    public Vector<Ability> getAbilities() {
        return abilities;
    }
}
