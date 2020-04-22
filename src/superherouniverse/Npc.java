package superherouniverse;

import java.util.Vector;

abstract class Npc {
    private String name;
    protected int health;

    static Npc create(NpcClass n) {
        switch (n) {
            case VILLAIN:
                return new Villain();
            case HERO:
                return new Hero();
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void damageHealth(int damage) {
        this.health -= damage;
    }

    abstract Vector<Ability> getAbilities();
}