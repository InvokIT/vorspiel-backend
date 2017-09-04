package dk.invokit.vorspiel;

import javax.validation.constraints.NotNull;
import java.util.Collection;

/**
 * Created by sj on 7/3/17.
 */
public class GameImpl implements Game {
    private final String id;
    private final String name;
    private final Image image;
    private final Collection<Ruleset> rulesets;
    private final Collection<Scenario> scenarios;
    private final Collection<Faction> factions;

    public GameImpl(
            @NotNull String id,
            @NotNull String name,
            @NotNull Image image,
            @NotNull Collection<Ruleset> rulesets,
            @NotNull Collection<Scenario> scenarios, Collection<Faction> factions) {

        this.id = id;
        this.name = name;
        this.image = image;
        this.rulesets = rulesets;
        this.scenarios = scenarios;
        this.factions = factions;

        if (this.rulesets.isEmpty()) {
            throw new IllegalArgumentException("rulesets is empty.");
        }
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public Collection<Ruleset> getRulesets() {
        return rulesets;
    }

    @Override
    public Collection<Scenario> getScenarios() {
        return this.scenarios;
    }

    @Override
    public Collection<Faction> getFactions() {
        return this.factions;
    }

    @Override
    public Image getImage() {
        return image;
    }
}
