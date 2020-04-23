import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import superherouniverse.Ability;
import superherouniverse.AbilityList;
import superherouniverse.Base;
import superherouniverse.Combat;
import superherouniverse.Location;
import superherouniverse.LocationList;
import superherouniverse.Npc;
import superherouniverse.NpcClass;



public class GameTest {
    Npc hero;
    Npc villain;
    Location location;
    Base heroBase;


    /**
     * Refresh heroes/villains/locations.
     */
    @Before
    public void setUp() {
        hero = Npc.create(NpcClass.HERO);
        villain = Npc.create(NpcClass.VILLAIN);
        location = new Location();
    }

    @Test
    public void combatTestHeroWin() {
        Combat combat = new Combat();
        villain.damageHealth(40); // Put our Villain at a disadvantage so the hero always wins
        combat.replaceNpcs(hero, villain);
        assertTrue(combat.runCombatSim());
    }

    @Test
    public void combatTestVillainWin() {
        Combat combat = new Combat();
        hero.damageHealth(80); // Put our Hero at a disadvantage so the villain always wins
        combat.replaceNpcs(hero, villain);
        assertFalse(combat.runCombatSim());
    }

    @Test
    public void locationNumberTest() {
        assertEquals(6, LocationList.locationPool.size());
    }

    @Test
    public void testHeroBase() {
        Vector<Npc> npcs = new Vector<>();
        npcs.add(hero);
        heroBase = new Base(npcs, NpcClass.HERO);
        location.addBase(heroBase);
        assertEquals(heroBase, location.getHeroBase());
    }

    @Test
    public void addDuplicateAbilityTest() {
        int oldValue = hero.getAbilities().get(0).getDamage();
        hero.addAbility(hero.getAbilities().get(0));
        assertEquals(oldValue * 2, hero.getAbilities().get(0).getDamage());
    }

    @Test
    public void addNewAbility() {
        Ability a = AbilityList.villainAbilities.get(0);
        hero.addAbility(a);
        assertEquals(a, hero.getAbilities().get(1));
    }

    @Test
    public void baseRemoveIsEmpty() {
        Vector<Npc> npcs = new Vector<>();
        npcs.add(villain);
        Base base = new Base(npcs, NpcClass.VILLAIN);
        base.removeNpc(villain);
        assertTrue(base.isEmpty());
    }

}
