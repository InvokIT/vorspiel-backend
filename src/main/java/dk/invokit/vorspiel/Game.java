package dk.invokit.vorspiel;

import java.util.Collection;

/**
 * Created by sj on 7/3/17.
 */
public interface Game {
    String getId();

    String getName();

    Image getImage();

    Collection<Ruleset> getRulesets();

    Collection<Scenario> getScenarios();

    Collection<Faction> getFactions();
}
