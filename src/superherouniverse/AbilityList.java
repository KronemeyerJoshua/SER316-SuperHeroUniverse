package superherouniverse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class AbilityList {
    public static final List<Ability> HeroAbilities = Collections.unmodifiableList(
            new ArrayList<Ability>() {{
                add(new Ability(10, "SLAP YO FACE", "SLAP"));
            }});

    public static final List<Ability> VillianAbilities = Collections.unmodifiableList(
            new ArrayList<Ability>() {{
                add(new Ability(8, "PICKPOCKET", "PICKPOCKET"));
            }});

    private AbilityList() {
    }

}
