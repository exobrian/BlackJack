import lombok.Getter;
import lombok.Setter;

public class Card {
    @Getter @Setter
    private String rank;
    @Getter @Setter
    private String face;
    @Getter @Setter
    private int value;

    @Override
    public String toString(){
        return (this.rank + " of " + this.face);
    };

    //Constructor using rank and face from Deck
    public Card(String rank, String face){
        this.rank = rank;
        this.face = face;
    }

}
