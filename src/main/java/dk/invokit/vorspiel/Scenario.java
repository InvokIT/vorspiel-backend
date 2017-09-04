package dk.invokit.vorspiel;

/**
 * Created by sj on 7/3/17.
 */
public interface Scenario {
    String getId();

    String getName();

    Image getImage();

    int[] getAvailableStartingPositions(Team team);
}
