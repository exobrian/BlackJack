package com.blackjack.exobrian;

import java.util.Scanner;

public class GameController {
    Deck deck = new Deck();
    Player player = new Player(deck);
    Dealer dealer = new Dealer(deck);
    Scanner scanner = new Scanner(System.in);

    //Game Loop
    public void startGame() {
        //Player's turn
        loop:
        while (!deck.getDeck().isEmpty()) {
            //Player BlackJack check
            if (player.getValue() == 21) {
                System.out.println("Player has BlackJack!\n");
                break loop;
            }
            System.out.println("\nPress h to hit, s to stand. \nPress q to quit: ");
            String input = scanner.nextLine();
            switch (input) {
                //Player can quit anytime
                case "q":
                    System.out.println("Thanks for playing!");
                    System.exit(0);
                case "h":
                    player.hit(deck);
                    player.showHand();
                    player.printValue();
                    if (player.isBust()) {
                        System.out.println("Player Bust.\n");
                        dealer.showHand();
                        System.out.println("Dealer wins.");
                        System.exit(0);
                    } else if (player.getValue() == 21) {
                        break loop;
                    }
                    break;
                case "s":
                    break loop;
            }
        }

        //Dealer takes turn after Player.
        dealer.takeTurn();
        dealer.showHand();
        dealer.printValue();

        //Win Condition Check
        //If neither busted, check for closest score to 21.
        //Else check who busted to figure out the loser.
        if (!player.isBust() && !dealer.isBust()) {
            if (player.getValue() < dealer.getValue()) {
                System.out.println("Dealer wins.");
            } else if (player.getValue() > dealer.getValue()) {
                System.out.println("Player wins");
            } else
                System.out.println("It's a push.");
        } else if (!player.isBust() && dealer.isBust()) {
            System.out.println("Player wins");
        }
    }
}