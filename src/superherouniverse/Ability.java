package superherouniverse;

public class Ability {
    private int damage;
    private String description;
    private String name;

    /**
     * Constructor for ability.
     * @param damage ability damage
     * @param description ability description
     * @param name ability name
     */
    public Ability(int damage, String description, String name) {
        this.damage = damage;
        this.description = description;
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Ability)) {
            return false;
        }

        Ability a = (Ability)o;
        return this.getName().equals(a.getName())
                && this.getDescription().equals(a.getDescription());
    }

    @Override
    public int hashCode() {
        assert false : "hashCode not designed";
        return 42; // any arbitrary constant will do
    }
}
