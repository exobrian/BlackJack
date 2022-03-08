package com.blackjack.exobrian;

import lombok.Getter;
import lombok.Setter;

public class Dealer extends Player{
    @Getter @Setter
    private Deck deck;
    private boolean isBust;

        //Constructs dealer using player class. Deals two cards, but hides one from print.
        public Dealer(Deck deck) {
            this.deck = deck;
            this.isBust = false;
            this.getHand().add(deck.drawCard());
            this.getHand().add(deck.drawCard());
            System.out.println("DEALER Hand:");
            System.out.println(this.getHand().get(0).toString());
            System.out.println("[Hidden]");
        }

        //Dealer turn at end of player's moves. Dealer always hits until hand >= 17.
        public void takeTurn() {
            System.out.println("Dealer takes its turn.");
            while (this.getValue() < 17){
                this.hit(deck);
            }
        }
}
