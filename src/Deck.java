import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Deck {
    public HashMap<Integer, Card> deck = new HashMap<>();
    private String[] faces = {"Clubs", "Spades", "Hearts", "Diamonds"};
    private String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    public Deck() {
        int k = 0;
        for (int i = 0; i < ranks.length; i++) {
            for (int j = 0; j < faces.length; j++) {
                deck.put(k, new Card(ranks[i], faces[j]));
                k++;
            }
        }
    }

    public Card drawCard(){
        Integer randomNumber = new Random().nextInt(deck.size());
        Card drawnCard = deck.get(randomNumber);
        deck.remove(randomNumber);
        return drawnCard;
    }

    public void printDeck(){
        System.out.printf("There are %d cards left in the deck.", deck.size());
        for (Integer key: deck.keySet()){
            System.out.println(deck.get(key).toString());
        }
    }

    //Old versions
    public void createDeck(){
        int numberOfDecks = 1;
        List<Integer> values = new ArrayList<Integer>(13);
        String[] faces = {"Clubs", "Spades", "Hearts", "Diamonds"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        HashMap<Integer, String> deck  = new HashMap<Integer, String>();

        int k = 0;
        for (int i = 0; i < 13; i++){
            for (int j = 0; j < faces.length; j++){
                deck.put(k, ranks[i] + " of " + faces[j]);
                k++;
            }
        }
        Integer randomNumber = new Random().nextInt(53);
        System.out.println(deck.get(randomNumber));
    }
    public void createDeck2(){
        String[] faces = {"Clubs", "Spades", "Hearts", "Diamonds"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        ArrayList<ArrayList<String>> deck = new ArrayList<>(ranks.length);

        for (int i = 0; i<ranks.length; i++){
            deck.add(new ArrayList<String>(faces.length));
            for (int j = 0; j<faces.length; j++){
                deck.get(i).add(faces[j]);
            }
        }
        Integer randomRankNumber = new Random().nextInt(ranks.length);
        Integer randomFaceNumber = new Random().nextInt(faces.length);
        System.out.println(ranks[randomRankNumber] + " of " + faces[randomFaceNumber]);
    }

}
