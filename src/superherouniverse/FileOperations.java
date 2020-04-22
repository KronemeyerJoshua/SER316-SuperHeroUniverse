package superherouniverse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class FileOperations {

    public static final String abilityDataLoc;
    public static final String heroDataLoc;
    public static final String villainDataLoc;
    public static final String locationDataLoc;

    static {
        abilityDataLoc = "_data/abilities.json";
        heroDataLoc = "_data/heroes.json";
        villainDataLoc = "_data/villains.json";
        locationDataLoc = "_data/locations.json";
    }

    public static String readFile(String filename) throws IOException {
        StringBuilder loadData = new StringBuilder();
        String s;
        BufferedReader fileInput = new BufferedReader(new FileReader(filename));
        while ((s = fileInput.readLine()) != null) {
            loadData.append(s);
        }

        return loadData.toString();
    }
}
