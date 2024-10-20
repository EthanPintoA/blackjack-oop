package main.java.players;

/** Interface for players that can take actions such as hitting. */
public interface IPlayerAction {
    /**
     * Determines if the player wants to hit.
     * 
     * @return True if the player wants to hit, false otherwise.
     */
    boolean wantsToHit();
}
