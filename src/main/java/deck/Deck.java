package main.java.deck;

import java.util.ArrayList;
import java.util.List;

import main.java.datastructures.Stack;

/** Represents a deck of cards. */
public class Deck {
    private Stack<Card> deck;

    public Deck() {
        deck = buildDeck();
        deck.shuffle();
    }

    /** Initializes the deck with 52 cards. */
    private static Stack<Card> buildDeck() {
        Stack<Card> deck = new Stack<>();
        String[] suits = { "Hearts", "Diamonds", "Clubs", "Spades" };
        String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

        for (String suit : suits) {
            for (String rank : ranks) {
                deck.push(new Card(rank, suit));
            }
        }

        return deck;
    }

    /**
     * Draws a card from the deck.
     * 
     * @return The card drawn from the deck.
     */
    public Card drawCard() {
        return deck.pop();
    }

    /**
     * Draws a specified number of cards from the deck.
     * 
     * @param numCards The number of cards to draw.
     * @return A list of cards drawn from the deck.
     */
    public List<Card> drawCard(int numCards) {
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < numCards; i++) {
            cards.add(deck.pop());
        }

        return cards;
    }
}
