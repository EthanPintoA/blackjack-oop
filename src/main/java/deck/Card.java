package main.java.deck;

/** Represents a playing card with a rank and a suit. */
public class Card {
    private String rank;
    private String suit;

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    /**
     * Returns the value of the card. For numbered cards, the value is the number
     * on the card. For face cards, the value is 10. For an Ace, the value is 11.
     * 
     * @return The value of the card
     * @throws IllegalArgumentException If the rank of the card is invalid
     */
    public int getValue() throws IllegalArgumentException {
        if (rank.equals("Ace")) {
            return 11;
        } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
            return 10;
        } else {
            try {
                return Integer.parseInt(rank);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException("Invalid card rank: " + rank);
            }
        }
    }

    @Override
    public String toString() {
        return "[" + rank + " of " + suit + "]";
    }
}
