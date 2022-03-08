package com.blackjack.exobrian;

import java.util.ArrayList;
import java.util.Arrays;
import lombok.Getter;
import lombok.Setter;

public class Player {
    @Getter @Setter
    private ArrayList<Card> hand = new ArrayList<Card>();
    @Getter @Setter
    private Deck deck;
    @Getter @Setter
    private boolean isBust;

    //Default Constructor; empty for Dealer subclass to use as no arg constructor.
    public Player() {
    }

    //Constructor for a player; deals 2 starting cards.
    public Player(Deck deck){
        this.deck = deck;
        this.isBust = false;
        this.getHand().add(deck.drawCard());
        this.getHand().add(deck.drawCard());
        this.showHand();
        this.printValue();
    }

    //Draws one card into hand. Also sets bust boolean.
    public void hit(Deck deck){
        this.getHand().add(deck.drawCard());
        if (this.getValue() > 21){
            this.isBust = true;
        }
    }

    //Prints out all cards in hand.
    public void showHand(){
        String className = this.getClass().getSimpleName();
        System.out.printf("%S Hand: \n", className);
        for (Card card : this.hand){
            System.out.println(card.toString());
        }
    }

    //Calculates value of hand. Checks for aces to maximize value while remaining under 21.
    public int getValue(){
        int value = 0;
        int sum = 0;
        int aceCount = 0;
        int aceCounter = 0;
        String[] ranks = Deck.getRanks();

        //Add up card values in hand.
        for (Card card : this.hand){
            if (card.getRank() == "Ace"){
                aceCount++;
            }
        value = Arrays.asList(ranks).indexOf(card.getRank()) > 9 ? 10: Arrays.asList(ranks).indexOf(card.getRank()) + 1;
        sum += value;
        }

        //For any aces, add another 10 (to make its value equal 11). Stop if sum > 21.
        while (sum + aceCounter*10 <= 21 && aceCounter <= aceCount){
            sum += aceCounter*10;
            aceCounter++;
        }
        return sum;
    }

    //Prints value of hand
    public void printValue(){
        System.out.println("Value: " + this.getValue() + "\n");
    }
}