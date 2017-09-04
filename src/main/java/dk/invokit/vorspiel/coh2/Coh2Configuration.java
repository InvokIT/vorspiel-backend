package dk.invokit.vorspiel.coh2;

import dk.invokit.vorspiel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;

/**
 * Created by sj on 7/3/17.
 */
@Configuration
@Profile("coh2")
public class Coh2Configuration {
    @Autowired
    private ImageLoader imageLoader;

    private Image image() throws IOException {
        return imageLoader.loadImage("coh2/image.png");
    }

    @Bean
    public Game coh2Game(Collection<Coh2Ruleset> rulesets) throws IOException {
        final GameImpl game = new GameImpl(
                "coh2",
                "Company of Heroes 2",
                this.image(),
                Collections.unmodifiableCollection(rulesets),
                this.scenarios(),
                this.factions()
        );

        return game;
    }

    private Collection<Scenario> scenarios() throws IOException {
        return Arrays.asList(
                createScenario("crossroads", "Crossroads", new int[]{1}, new int[]{2}),
                createScenario("crossing_in_the_woods", "Crossing in the Woods", new int[]{1, 3}, new int[]{2, 4}),
                createScenario("faymonville_approach", "Faymonville Approach", new int[]{1}, new int[]{2}),
                createScenario("kholodny_ferma_summer", "Kholodny Ferma (Summer)", new int[]{1}, new int[]{2})
        );
    }

    private Scenario createScenario(String scenarioId, String scenarioName, int[] allyStartingPositions, int[] axisStartingPositions) throws IOException {
        return createScenario(scenarioId, scenarioName, scenarioId, allyStartingPositions, axisStartingPositions);
    }

    private Scenario createScenario(String scenarioId, String scenarioName, String imageName, int[] allyStartingPositions, int[] axisStartingPositions) throws IOException {
        return new ScenarioImpl(
                scenarioId,
                scenarioName,
                imageLoader.loadImage(String.format("coh2/scenarios/%s.jpg", imageName))
        ) {
            @Override
            public int[] getAvailableStartingPositions(Team team) {
                final Optional<Alliance> alliance = team.getPlayers().stream()
                        .map(player -> player.getFaction())
                        .filter(faction -> faction != null)
                        .map(faction -> ((Coh2Faction) faction).getAlliance())
                        .findFirst();

                if (alliance.isPresent()) {
                    return alliance.get() == Alliance.ALLIES ? allyStartingPositions : axisStartingPositions;
                } else {
                    return new int[0];
                }
            }
        };
    }

    private Collection<Faction> factions() throws IOException {
        return Arrays.asList(
                new Coh2Faction("sov", "Soviets", imageLoader.loadImage("coh2/factions/soviets.png"), Alliance.ALLIES),
                new Coh2Faction("usf", "United States Forces", imageLoader.loadImage("coh2/factions/usf.png"), Alliance.ALLIES),
                new Coh2Faction("ukf", "United Kingdom Forces", imageLoader.loadImage("coh2/factions/ukf.png"), Alliance.ALLIES),
                new Coh2Faction("ost", "Ostheer", imageLoader.loadImage("coh2/factions/ostheer.png"), Alliance.AXIS),
                new Coh2Faction("okw", "Oberkommando West", imageLoader.loadImage("coh2/factions/okw.png"), Alliance.AXIS)
        );
    }
}
