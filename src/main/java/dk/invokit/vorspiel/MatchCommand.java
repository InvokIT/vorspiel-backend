package dk.invokit.vorspiel;

/**
 * Created by sj on 7/3/17.
 */
public interface MatchCommand {
    MatchState invoke(MatchState match);
}
