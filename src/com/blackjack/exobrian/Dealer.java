package com.blackjack.exobrian;

public class Dealer extends Player{
        public Dealer(Deck deck) {
            //Deal com.blackjack.exobrian.Player a hand with two cards drawn from the deck
            this.getHand().add(deck.drawCard());
            this.getHand().add(deck.drawCard());
            System.out.println("DEALER Hand: ");
            System.out.println(this.getHand().get(0).toString());
            System.out.println("[Hidden]");
        }
        public void takeTurn() {
            System.out.println("com.blackjack.exobrian.Dealer takes its turn.");
            this.showHand();
        }
}
