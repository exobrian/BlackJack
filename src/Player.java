import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Arrays;

public class Player {
    @Getter @Setter
    private ArrayList<Card> hand = new ArrayList<Card>();

    public Player() {
    }

    public Player(Deck deck){
        //Deal Player a hand with two cards drawn from the deck
        this.getHand().add(deck.drawCard());
        this.getHand().add(deck.drawCard());
        this.showHand();
        System.out.println("Hand Value: " + this.getValue());
    }

    public void hit(Deck deck){
        this.getHand().add(deck.drawCard());
        this.showHand();
        System.out.println("Hand Value: " + this.getValue());
    }

    public void showHand(){
        String className = this.getClass().getSimpleName();
        System.out.printf("%S Hand: ", className);
        for (Card card : this.hand){
            System.out.println(card.toString());
        }
    }

    public int getValue(){
        int value;
        int sum = 0;
        int aceCount = 0;
        int aceCounter = 0;

        String[] ranks = Deck.getRanks();  //{"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

        //Clean this up later
        //Add up card values in hand. Then for any aces, add another 10 (to make its value equal 11). Stop if sum > 21.
        for (Card card : this.hand){
            if (card.getRank() == "Ace"){
                aceCount++;
            }
        value = Arrays.asList(ranks).indexOf(card.getRank()) > 9 ? 10: Arrays.asList(ranks).indexOf(card.getRank()) + 1;
        sum += value;
        }
        while (sum + aceCounter*10 <= 21 && aceCounter <= aceCount){
            sum += aceCounter*10;
            aceCounter++;
        }
        return sum;
    }
}