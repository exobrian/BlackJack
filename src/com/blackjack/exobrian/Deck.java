package com.blackjack.exobrian;

import java.util.ArrayList;
import java.util.Random;
import lombok.Getter;
import lombok.Setter;

public class Deck {
    @Getter @Setter
    private ArrayList<Card> deck = new ArrayList<>();
    @Getter @Setter
    private final static String[] faces = {"Clubs", "Spades", "Hearts", "Diamonds"};
    @Getter @Setter
    private final static String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    //Constructor; makes deck of 52 cards
    public Deck() {
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                deck.add(new Card(ranks[i], faces[j]));
            }
        }
    }

    //Removes card from deck then returns it
    public Card drawCard(){
        int randomNumber = new Random().nextInt(deck.size());
        Card drawnCard = deck.get(randomNumber);
        deck.remove(randomNumber);
        return drawnCard;
    }

    //Prints every card left in the deck. Used for debugging.
    public void printDeck(){
        System.out.printf("There are %d cards left in the deck.", deck.size());
        for (int i = 0; i < deck.size(); i++){
            System.out.println(deck.get(i).toString());
        }
    }
}
