package dk.invokit.vorspiel;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by sj on 7/13/17.
 */
public class MatchImpl implements Match {
    private final Deque<MatchState> stateStack = new LinkedList<>();
    private final Object stateLock = new Object();

    public MatchImpl() {

    }

    @Override
    public void pushState(final MatchState newState) {
        synchronized (stateLock) {
            this.stateStack.addFirst(newState);
        }
    }

    @Override
    public MatchState popState() {
        synchronized (stateLock) {
            return this.stateStack.removeFirst();
        }
    }

    @Override
    public MatchState peekState() {
        return this.stateStack.peekFirst();
    }
}
