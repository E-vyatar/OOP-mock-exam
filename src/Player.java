import java.util.List;
import java.util.Objects;

public class Player {

    private CardPack cardPack;

    private int gold;

    public Player(CardTypes cardTypes) {
        this.cardPack = new CardPack(cardTypes);
        this.gold = 0;
    }

    public CardPack getCardPack() {
        return cardPack;
    }

    public void printCards() {
        List<Card> cardss = cardPack.getCards();
        String res = "";
        for (Card card : cardss) {
            res += card.toString() + "\n";
        }
        System.out.println(res);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return gold == player.gold && Objects.equals(getCardPack(), player.getCardPack());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCardPack(), gold);
    }
}
