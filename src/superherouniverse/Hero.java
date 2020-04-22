package superherouniverse;

import java.util.Vector;

public class Hero extends Npc {
    Vector<Ability> abilities;
    public Hero() {
        abilities = new Vector<>();
        abilities.add(new Ability(10, "HolyNova", "HolyNova"));
        super.setName("HERO");
        super.health = 100;
    }

    @Override
    public Vector<Ability> getAbilities() {
        return abilities;
    }
}
