import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CardPack {

    private List<Card> cards;

    /**
     * constructor
     * @param cardTypes cards to build pack from
     */
    public CardPack(CardTypes cardTypes) {
        cards = new ArrayList<>();
        for (int i=0; i<5;++i) {
            add(cardTypes.draw());
        }
    }

    /**
     * add a card to the pack
     * @param card card to add
     */
    public void add(Card card) {
        cards.add(card);
    }

    /**
     * get all cards in the pack
     * @return list o cards in the pack
     */
    public List<Card> getCards() {
        return cards;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CardPack)) return false;
        CardPack cardPack = (CardPack) o;
        return Objects.equals(getCards(), cardPack.getCards());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCards());
    }
}
