package dk.invokit.vorspiel;

/**
 * Created by sj on 7/3/17.
 */
public interface Match {
    void pushState(MatchState newState);

    MatchState popState();

    MatchState peekState();
}
