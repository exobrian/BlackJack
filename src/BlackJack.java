import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args){
        Deck deck = new Deck();
        Player player = new Player();
        Scanner scanner = new Scanner(System.in);
        player.deal(deck);

        player.showHand();

        while (true){
            System.out.println("Press h to hit, s to stand. \n Press q to quit: ");
            String input = scanner.nextLine();
            if (input.equals("q")){
                break;
            }
            System.out.println(player.getValue());
        }
        //returning the value of your hand
    }


}
