package main.java;

import java.util.Scanner;

import main.java.datastructures.Queue;
import main.java.players.HumanPlayer;

/** The main class that runs the game. */
public class App {
    public static void main(String[] args) {
        Queue<HumanPlayer> players = new Queue<>();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the names of the players: ");
        for (int i = 0; i < numPlayers; i++) {
            String name = scanner.nextLine();
            players.enqueue(new HumanPlayer(name));
        }
        System.out.println();

        Game<HumanPlayer> game = new Game<>(players);

        game.playRound();
    }
}
