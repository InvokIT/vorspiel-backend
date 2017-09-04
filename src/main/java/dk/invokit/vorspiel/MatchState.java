package dk.invokit.vorspiel;

import java.util.Collection;

/**
 * Created by sj on 7/3/17.
 */
public interface MatchState {
    Collection<MatchCommand> getAllowedCommands();
}
