import java.util.Objects;

public class Card {

    public enum CardType {
        NORMAL,
        RARE,
        EPIC,
        LEGENDARY
    }

    private CardType rarity;

    private String name;

    private int energyCost;

    /**
     * set rarity
     * @param rarity value to set
     */
    public void setRarity(String rarity) {
        for (CardType cardType : CardType.values()) {
            if (rarity.equals(cardType.name())) {
                this.rarity = cardType;
                break;
            }
        }
    }

    /**
     * set name
     * @param name value to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set energy cost
     * @param energyCost value to set
     */
    public void setEnergyCost(int energyCost) {
        this.energyCost = energyCost;
    }

    /**
     * get rarity
     * @return value of rarity field
     */
    public CardType getRarity() {
        return rarity;
    }

    /**
     *
     * @return string representation of th object
     */
    @Override
    public String toString() {
        return rarity + " card named " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return energyCost == card.energyCost
                && Objects.equals(getRarity(), card.getRarity()) && Objects.equals(name, card.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRarity(), name, energyCost);
    }
}
