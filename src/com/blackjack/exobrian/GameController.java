package com.blackjack.exobrian;

import java.util.Scanner;

public class GameController {
    Deck deck = new Deck();
    Player player = new Player(deck);
    Dealer dealer = new Dealer(deck);
    Scanner scanner = new Scanner(System.in);

    //Game Loop
    public void startGame() {
        loop:
        while (true) {
            System.out.println("\nPress h to hit, s to stand. \nPress q to quit: ");
            String input = scanner.nextLine();
            switch (input) {
                case "q":
                    break loop;
                case "h":
                    player.hit(deck);
                    if (player.getValue() > 21) {
                        System.out.println("Bust.");
                        dealer.takeTurn();
                        break loop;
                    }
                    if (player.getValue() == 21) {
                        System.out.println("21.");
                        dealer.takeTurn();
                        break loop;
                    }
                    break;
                case "s":
                    dealer.takeTurn();
                    break loop;
            }
        }
    }
}