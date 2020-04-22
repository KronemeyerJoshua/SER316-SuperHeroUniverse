package superherouniverse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Vector;

public final class HeroList {
    public static final Vector<Npc> heroPool;

    /*
     * Loads the AbilityList for heroes and villains
     */
    static {
        // Get our heroes from local game data
        JSONObject heroes = null;
        try {
            heroes = new JSONObject(FileOperations.readFile(FileOperations.heroDataLoc));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Temp Vectors
        Vector<Npc> heroBuilder = new Vector<>();

        // Get our heroes and make them into Hero
        JSONArray heroArray = heroes.getJSONArray("heroes");
        // System.out.println(abilityArray.getJSONObject(0).toString());
        for (int i = 0; i < heroArray.length(); i++) {
            JSONObject hero = heroArray.getJSONObject(i);
            heroBuilder.add(new Hero(hero.getString("name"), hero.getInt("health")));
        }

        // Initialize our static properties
        heroPool = heroBuilder;
    }

}
