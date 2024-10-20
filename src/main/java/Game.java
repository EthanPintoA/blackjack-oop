package main.java;

import main.java.datastructures.Queue;
import main.java.deck.Deck;
import main.java.players.Dealer;
import main.java.players.IPlayerAction;
import main.java.players.Player;

/** Represents a game of Blackjack. */
public class Game<P extends Player & IPlayerAction> {
    private Deck deck;
    private Dealer dealer;
    private Queue<P> players;

    public Game(Queue<P> players) {
        deck = new Deck();
        dealer = new Dealer();
        this.players = players;
    }

    public void playRound() {
        for (Player player : players) {
            // Uses an overloaded method to draw 2 cards
            player.receiveCard(deck.drawCard(2));
        }

        // Doesn't use the overloaded method.
        dealer.receiveCard(deck.drawCard());
        dealer.receiveCard(deck.drawCard());

        System.out.println("Dealer's hand: " + dealer.showOneCard());
        System.out.println();

        playersTurn();

        dealerTurn();

        determineWinner();
    }

    private void playersTurn() {
        for (int i = 0; i < players.size(); i++) {
            P player = players.dequeue(); // Dequeue the player to get their turn

            System.out.println(player.getName() + "'s turn.");
            System.out.println(player.getName() + "'s hand: " + player.showHand());
            // Make sure the player is not busted and wants to hit
            // before drawing a card. Repeat until the player is busted or doesn't want to
            // hit.
            while (!player.isBusted() && player.wantsToHit()) {
                player.receiveCard(deck.drawCard());
                System.out.println(player.getName() + "'s hand: " + player.showHand());
            }

            if (player.isBusted()) {
                System.out.println(player.getName() + " is busted!");
            }

            System.out.println();

            players.enqueue(player); // Enqueue the player back to the end of the queue
        }
    }

    private void dealerTurn() {
        while (dealer.shouldHit()) {
            dealer.receiveCard(deck.drawCard());
        }
        System.out.println("Dealer's hand: " + dealer.showHand());
        if (dealer.isBusted()) {
            System.out.println("Dealer is busted!");
        }
    }

    private void determineWinner() {
        for (Player player : players) {
            if (player.isBusted()) {
                System.out.println(player.getName() + " loses!");
            } else if (dealer.isBusted()) {
                System.out.println(player.getName() + " wins!");
            } else if (player.getHandValue() > dealer.getHandValue()) {
                System.out.println(player.getName() + " wins!");
            } else if (player.getHandValue() < dealer.getHandValue()) {
                System.out.println(player.getName() + " loses!");
            } else { // Hand values are equal
                System.out.println(player.getName() + " ties with the dealer!");
            }
        }
    }
}
