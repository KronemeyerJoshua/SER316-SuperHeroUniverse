package superherouniverse;

public enum Stats {
    VILLIAN_SPAWN_CHANCE(0.3),
    HERO_BORN_CHANCE(0.2),
    VILLIAN_CRIT_CHANCE(0.2),
    HERO_CRIT_CHANCE(0.6);

    private double chance;

    public double getChance() {
        return this.chance;
    }

    Stats(double chance) {
        this.chance = chance;
    }
}
