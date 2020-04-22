package superherouniverse;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Vector;

public final class AbilityList {
    public static final Vector<Ability> heroAbilities;
    public static final Vector<Ability> villainAbilities;

    /*
     * Loads the AbilityList for heroes and villains
     */
    static {
        // Get our abilities from local game data
        JSONObject abilities = null;
        try {
            abilities = new JSONObject(FileOperations.readFile(FileOperations.abilityDataLoc));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Temp Vectors
        Vector<Ability> heroAbilitiesBuilder = new Vector<>();
        Vector<Ability> villainAbilitiesBuilder = new Vector<>();

        // Get our hero abilities and make them into Ability
        JSONArray abilityArray = abilities.getJSONArray("heroAbilities");
        // System.out.println(abilityArray.getJSONObject(0).toString());
        for (int i = 0; i < abilityArray.length(); i++) {
            JSONObject ability = abilityArray.getJSONObject(i);
            heroAbilitiesBuilder.add(new Ability(ability.getInt("damage"), ability.getString("description"), ability.getString("name")));
        }

        // Get our villain abilities and make them into Ability
        abilityArray = abilities.getJSONArray("villainAbilities");
        for (int i = 0; i < abilityArray.length(); i++) {
            JSONObject ability = abilityArray.getJSONObject(i);
            villainAbilitiesBuilder.add(new Ability(ability.getInt("damage"), ability.getString("description"), ability.getString("name")));
        }


        // Initialize our static properties
        heroAbilities = heroAbilitiesBuilder;
        villainAbilities = villainAbilitiesBuilder;
    }

}
