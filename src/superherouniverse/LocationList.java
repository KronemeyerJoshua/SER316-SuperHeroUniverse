package superherouniverse;

import java.io.IOException;
import java.util.Vector;

import org.json.JSONArray;
import org.json.JSONObject;


public final class LocationList {
    public static final Vector<Location> locationPool;

    /*
     * Loads the Locations from file
     */
    static {
        // Get our locations from local game data
        JSONObject locations = null;
        try {
            locations = new JSONObject(FileOperations.readFile(FileOperations.locationDataLoc));
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Temp Vectors
        Vector<Location> locationBuilder = new Vector<>();

        if (locations != null) {
            // Get our Locations and make them into a Location
            JSONArray locationArray = locations.getJSONArray("locations");
            // System.out.println(abilityArray.getJSONObject(0).toString());
            for (int i = 0; i < locationArray.length(); i++) {
                JSONObject loc = locationArray.getJSONObject(i);
                locationBuilder.add(new Location(loc.getString("name"),
                        false, loc.getDouble("encounterChance")));
            }
        }
        // Initialize our static properties
        locationPool = locationBuilder;
    }

}
