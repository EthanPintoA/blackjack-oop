package main.java.players;

/** Represents an AI player in a game of Blackjack. */
public class AiPlayer extends Player implements IPlayerAction {
    /** A constant representing the threshold for when the AI player should hit. */
    private static final int HIT_THRESHOLD = 17;

    public AiPlayer(String name) {
        super(name);
    }

    @Override
    public boolean wantsToHit() {
        return getHandValue() < HIT_THRESHOLD;
    }
}
