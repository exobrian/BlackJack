import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player{
    @Getter @Setter
    public List<Card> hand = new ArrayList<Card>();

    public void deal(Deck deck){
        //Deal Player a hand with two cards drawn from the deck
        this.getHand().add(deck.drawCard());
        this.getHand().add(deck.drawCard());
    }

    public void hit(Deck deck){
        this.getHand().add(deck.drawCard());
    }

    public void showHand(){
        System.out.println("Player's Hand: ");
        for (Card card : this.hand){
            System.out.println(card.toString());
        }
    }

    public int getValue(){
        int value;
        int sum = 0;
        int aceCount = 0;
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        String[] royals = {"Jack", "Queen", "King"};

        System.out.println("\nTotal Value: ");
        for (Card card : this.hand){
            if (card.getRank() == "Ace"){
                aceCount++;
            }
        value = Arrays.asList(ranks).indexOf(card.getRank()) > 9 ? 10: Arrays.asList(ranks).indexOf(card.getRank()) + 1;
        sum = sum + value;
        }
        return sum;
    }
}
