package superherouniverse;

abstract class Npc {
    private String name;
    private int health;

    static Npc create(NpcClass n) {
        switch (n) {
            case VILLIAN:
                return new Villian();
                break;
            case HERO:
                return new Hero();
                break;
        }
    }
}