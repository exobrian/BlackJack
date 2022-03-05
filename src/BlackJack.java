import java.util.Scanner;

public class BlackJack {

    public static void main(String[] args){
        Deck deck = new Deck();
        Player player = new Player();
        Computer computer = new Computer();
        Scanner scanner = new Scanner(System.in);

        //First Deal
        player.deal(deck);

        //Game Loop
        loop: while (true){
            System.out.println("\nPress h to hit, s to stand. \nPress q to quit: ");
            String input = scanner.nextLine();
            switch (input){
                case "q":
                    break loop;
                case "h":
                    player.hit(deck);
                    if (player.getValue() > 21){
                        System.out.println("Bust.");
                        computer.takeTurn();
                        break loop;
                    }
                    if (player.getValue() == 21){
                        System.out.println("21.");
                        computer.takeTurn();
                        break loop;
                    }
                    break;
                case "s":
                    computer.takeTurn();
                    deck.printDeck();
                    break loop;
            }
        }
    }


}
