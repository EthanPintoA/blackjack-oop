package main.java.players;

import java.util.Scanner;

/** Represents a human player in a game of Blackjack. */
public class HumanPlayer extends Player implements IPlayerAction {
    public HumanPlayer(String name) {
        super(name);
    }

    /**
     * Asks the player if they want to hit.
     * Reads input from the console.
     * 
     * @return `true` if the player wants to hit, `false` otherwise
     */
    @Override
    public boolean wantsToHit() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to hit (y/n): ");
        String input = scanner.nextLine();
        return input.equals("y");
    }
}
