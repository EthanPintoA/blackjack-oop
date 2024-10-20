package main.java.players;

/** Represents the dealer in a game of Blackjack. */
public class Dealer extends Player {
    public Dealer() {
        super("Dealer");
        /*
         * // The above uses the Player constructor,
         * // which is equivalent to the following:
         * this.name = "Dealer";
         * this.hand = new ArrayList<>();
         */
    }

    /**
     * Determines if the dealer should hit.
     * The dealer should hit if their hand value is less than 17.
     * 
     * @return `true` if the dealer should hit, `false` otherwise
     */
    public boolean shouldHit() {
        return getHandValue() < 17;
    }

    /**
     * Shows only the first card in the dealer's hand.
     * 
     * @return The first card in the dealer's hand
     */
    public String showOneCard() {
        StringBuilder sb = new StringBuilder();
        sb.append(getHand().get(0));
        sb.append(" [Hidden Card]");
        return sb.toString();
    }
}
