import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class CardTypes {

    private List<Card> baseCards;

    private List<Card> cards;

    public CardTypes() {
        this.cards = new ArrayList<>();
        this.baseCards = new ArrayList<>();
        read();
    }

    public void read() {
        Scanner inputScanner = new Scanner(System.in);
        System.out.println("Enter file name :");
        String fileName = inputScanner.next();

        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("resources/" + fileName + ".txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        while (fileScanner.hasNext()) {
            String line =fileScanner.nextLine();
            for (int i=0;i<3;++i) {
                line += "\n" + fileScanner.nextLine();
            }
            Card card = decideWhichCard(line);

            if (card != null) {
                cards.add(card);
                baseCards.add(card);
            }
        }
    }

    private Card decideWhichCard(String line) {
        if (line.startsWith("Unit")) {
            return UnitCard.read(line);
        } else if (line.startsWith("Weapon")) {
            return WeaponCard.read(line);
        } else if (line.startsWith("Spell")) {
            return SpellCard.read(line);
        }

        return null;
    }

    public Card draw() {
        int normal = 0;
        int rare = 0;
        int epic = 0;
        int legendary = 0;
        int chance;
        for (Card card : cards) {
            if (card.getRarity().equals("NORMAL")) {
                ++normal;
                chance = 74;
            } else if (card.getRarity().equals("RARE")) {
                ++rare;
                chance = 16;

            } else if (card.getRarity().equals("EPIC")) {
                ++epic;
                chance = 8;

            } else if (card.getRarity().equals("LEGENDARY")) {
                ++legendary;
                chance = 2;
            }
        }

        int random = (int) (Math.random() * cards.size());
        Card card = cards.get(random);
        return cards.get(random);
    }

    @Override
    public String toString() {
        String res = "";
        for (Card card : cards) {
            res += card.toString() + "\n";
        }
        return res;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardTypes)) return false;
        CardTypes cardTypes = (CardTypes) o;
        return Objects.equals(baseCards, cardTypes.baseCards) && Objects.equals(cards, cardTypes.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(baseCards, cards);
    }
}
