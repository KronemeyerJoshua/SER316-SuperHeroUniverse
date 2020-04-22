package superherouniverse;

import java.util.Random;
import java.util.Vector;

public class Combat {
    Vector<Npc> heroes;
    Vector<Npc> villians;

    public Combat(Vector<Npc> heroes, Vector<Npc> villians) {
        this.heroes = heroes;
        this.villians = villians;
    }

    public boolean runCombatSim() {
        boolean heroesWin = true;

        while (heroes.size() > 0 && villians.size() > 0) {
            attackTarget(heroes, villians);
            attackTarget(villians, heroes);
        }

        if (villians.size() > 0)
            heroesWin = false;

        return heroesWin;
    }

    public void attackTarget(Vector<Npc> attackers, Vector<Npc> targets) {
        Random rnd = new Random();
        for (int i = 0; i < attackers.size(); i++) {
            Vector<Ability> abilities = attackers.get(i).getAbilities();
            Ability chosenAbility = abilities.get(rnd.nextInt(abilities.size()));
            Npc target = targets.get(rnd.nextInt(targets.size()));
            target.damageHealth(chosenAbility.getDamage());
            System.out.printf("%s has hit %s for %d damage%n", attackers.get(i).getName(), target.getName(), chosenAbility.getDamage());
            if (target.getHealth() < 1) {
                System.out.printf("%s has fainted.%n", target.getName());
                targets.remove(target);
                if (targets.size() < 1) {
                    break;
                }
            }
        }
    }

    public void checkHealth(Npc npc) {

    }
}
