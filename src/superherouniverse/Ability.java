package superherouniverse;

public class Ability {
    private int damage;
    private String description, name;

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
}
