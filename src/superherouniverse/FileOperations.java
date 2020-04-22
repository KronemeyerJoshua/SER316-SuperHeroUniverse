package superherouniverse;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public final class FileOperations {

    public static final String abilityDataLoc;

    static {
        abilityDataLoc = "_data/abilities.json";
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
