import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;

public class Player{
    @Getter @Setter
    public Card[] hand = new Card[2];

    public void deal(Deck deck){
        //Deal Player a hand with two cards drawn from the deck
        this.getHand()[0] = deck.drawCard();
        this.getHand()[1] = deck.drawCard();
    }

    public void showHand(){
        for (Card card : this.hand){
            System.out.println(card.toString());
        }
    }

    public int getValue(){
        int value = 0;
        int sum = 0;
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        for (Card card : this.hand){
            value = Arrays.asList(ranks).indexOf(card.getRank()) + 1;
            sum = sum + value;
        }
        return sum;
    }
}
