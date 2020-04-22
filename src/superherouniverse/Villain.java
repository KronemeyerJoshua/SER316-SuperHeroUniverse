package superherouniverse;

import java.util.Vector;

public class Villain extends Npc {
    Vector<Ability> abilities;
    public Villain() {
        abilities = new Vector<>();
        abilities.add(new Ability(10, "ShadowNova", "ShadowNova"));
        super.setName("VILLAIN");
        super.health = 100;
    }

    @Override
    public Vector<Ability> getAbilities() {
        return abilities;
    }
}
