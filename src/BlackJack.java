import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args){
        Deck deck = new Deck();
        Player player = new Player();
        Computer computer = new Computer();
        Scanner scanner = new Scanner(System.in);

        //First Deal
        player.deal(deck);
        player.showHand();

        //Game Loop
        loop: while (true){
            System.out.println("\nPress h to hit, s to stand. \nPress q to quit: ");
            String input = scanner.nextLine();
            switch (input){
                case "q":
                    break loop;
                case "h":
                    int j = player.getHand().size();
                    player.hit(deck);
                    player.showHand();
                    break;
                case "s":
                    computer.takeTurn();
                    break loop;
            }

            System.out.println(player.getValue());
        }
        //returning the value of your hand
    }


}
