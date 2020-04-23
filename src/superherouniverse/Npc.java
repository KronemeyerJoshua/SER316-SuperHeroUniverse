package superherouniverse;

import java.util.Vector;

public abstract class Npc {
    private String name;
    protected int health;
    protected Vector<Ability> abilities;

    /**
     * Abstract Factory for Villains/Heroes.
     * @param n The type of Npc you want
     * @return Villain/Hero, null if type unknown
     */
    public static Npc create(NpcClass n) {
        switch (n) {
            case VILLAIN:
                return new Villain();
            case HERO:
                return new Hero();
            default:
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

    /**
     * Adds/Empowers (if present) Abilities of Npc.
     * @param ability The ability to add/empower
     */
    public void addAbility(Ability ability) {
        if (abilities.contains(ability)) {
            System.out.println("Contain ability");
            Ability a = abilities.get(abilities.indexOf(ability));
            a.setDamage(a.getDamage() * 2);
        } else {
            abilities.add(ability);
        }
    }

    public abstract Vector<Ability> getAbilities();

}