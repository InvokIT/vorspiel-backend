package dk.invokit.vorspiel;

/**
 * Created by sj on 7/13/17.
 */
public class MatchControllerImpl {
    private final Match match;
    private final Object matchLock = new Object();

    public MatchControllerImpl(Match match) {
        this.match = match;
    }

    public void applyCommand(MatchCommand command) {
        synchronized (matchLock) {
            final MatchState oldState = this.match.peekState();
            final MatchState newState = command.invoke(oldState);
            this.match.pushState(newState);
        }
    }
}
