package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Combat {
    Npc hero;
    Npc villain;

    public Combat() {}

    /**
     * Runs a combat simulation between hero & villain.
     * @return Boolean if heroes have won
     */
    public boolean runCombatSim() {
        boolean heroesWin = true;

        while (hero.getHealth() > 0 && villain.getHealth() > 0) {
            attackSingleTarget(hero, villain);
            attackSingleTarget(villain, hero);
        }

        if (villain.getHealth() > 0) {
            heroesWin = false;
        }

        return heroesWin;
    }

    /**
     * A single attack to a target.
     * @param attacker Npc attacker
     * @param target Npc targeted
     */
    public void attackSingleTarget(Npc attacker, Npc target) {
        Random rnd = new Random();
        Vector<Ability> abilities = attacker.getAbilities();
        Ability chosenAbility = abilities.get(rnd.nextInt(abilities.size()));
        int damage = chosenAbility.getDamage();
        if (rnd.nextDouble() < Stats.VILLIAN_CRIT_CHANCE) {
            damage *= 2;
        }
        target.damageHealth(damage);
    }

    /**
     * Replaces the npcs in the combat simulation.
     * @param hero The replacement hero
     * @param villain The replacement villain
     */
    public void replaceNpcs(Npc hero, Npc villain) {
        this.hero = hero;
        this.villain = villain;
    }
}
