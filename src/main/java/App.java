package main.java;

import java.util.Scanner;
import java.util.ArrayList;

/** The main class that runs the game. */
public class App {
    public static void main(String[] args) {
        ArrayList<String> players = new ArrayList<>();

        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of players: ");
        int numPlayers = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the names of the players: ");
        for (int i = 0; i < numPlayers; i++) {
            String name = scanner.nextLine();
            players.add(name);
        }
        System.out.println();

        System.out.println(players);
    }
}
