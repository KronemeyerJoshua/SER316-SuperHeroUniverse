package superherouniverse;

import java.io.IOException;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;


public final class VillainList {
    public static final Vector<Npc> villainPool;

    /*
     * Loads the villains from the villains json file
     */
    static {
        // Get our heroes from local game data
        JSONObject villains = null;
        try {
            villains = new JSONObject(FileOperations.readFile(FileOperations.villainDataLoc));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Temp Vectors
        Vector<Npc> villainBuilder = new Vector<>();

        if (villains != null) {
            // Get our heroes and make them into Hero
            JSONArray villainArray = villains.getJSONArray("villains");
            // System.out.println(abilityArray.getJSONObject(0).toString());
            for (int i = 0; i < villainArray.length(); i++) {
                JSONObject hero = villainArray.getJSONObject(i);
                villainBuilder.add(new Villain(hero.getString("name"), hero.getInt("health")));
            }
        }
        // Initialize our static properties
        villainPool = villainBuilder;
    }

}
