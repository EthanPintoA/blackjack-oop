package main.java.players;

import java.util.ArrayList;
import java.util.List;

import main.java.deck.Card;

/** Represents a player in a game of Blackjack. */
public abstract class Player {
    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    /**
     * Receives a card and adds it to the player's hand.
     * 
     * @param card The card to receive
     */
    public void receiveCard(Card card) {
        hand.add(card);
    }

    /**
     * Receives a list of cards and adds them to the player's hand.
     * 
     * @param cards The list of cards to receive
     */
    public void receiveCard(List<Card> cards) {
        hand.addAll(cards);
    }

    /**
     * Checks if the player is busted (hand value > 21).
     * 
     * @return `true` if the player is busted, `false` otherwise
     */
    public boolean isBusted() {
        return getHandValue() > 21;
    }

    /**
     * Gets the value of the player's hand.
     * 
     * @return The value of the player's hand
     */
    public int getHandValue() {
        int handValue = 0;
        int numAces = 0;

        for (Card card : hand) {
            if (card.getRank().equals("Ace")) {
                numAces++;
            }
            handValue += card.getValue();
        }

        while (handValue > 21 && numAces > 0) {
            // Convert an Ace from 11 to 1
            handValue -= 11;
            handValue += 1;
            numAces--;
        }

        return handValue;
    }

    /**
     * Shows the player's hand.
     * 
     * @return The player's hand
     */
    public String showHand() {
        List<String> cardStrings = new ArrayList<>();
        for (Card card : hand) {
            cardStrings.add(card.toString());
        }
        return String.join(" ", cardStrings);
    }
}
