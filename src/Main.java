import java.util.Scanner;

public class Main {

    // You can start implementing in this project!
    // Good luck with the mock exam!
    public static void main(String[] args) {
        CardTypes cardTypes = new CardTypes();
        CardPack cardPack = new CardPack(cardTypes);
        Player player = new Player(cardTypes);
        System.out.println("");

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose an option: \n" +
                    "1 - Show all known cards\n" +
                    "2 - Show user's card collection and gold\n" +
                    "3 - Open a pack of cards\n" +
                    "4 - Save collection of file\n" +
                    "5 - Quit the application\n");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    System.out.println(cardTypes.toString());
                    break;
                case 2:
                    player.printCards();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.exit(0);
                    break;
            }
        }
    }
}
