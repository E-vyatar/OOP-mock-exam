import java.util.Objects;
import java.util.Scanner;

public class SpellCard extends Card{

    private String spellType;

    private String description;

    public void setSpellType(String spellType) {
        this.spellType = spellType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static SpellCard read(String input) {
        Scanner scanner = new Scanner(input);
        SpellCard spellCard = new SpellCard();
        scanner.nextLine();
        spellCard.setRarity(scanner.nextLine());
        scanner.useDelimiter(" - ");
        spellCard.setName(scanner.next());

        spellCard.setEnergyCost(Integer.parseInt(scanner.next().substring(0,1)));
        spellCard.setSpellType(scanner.nextLine().substring(3));

        spellCard.setDescription(scanner.nextLine());

        return spellCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SpellCard)) return false;
        if (!super.equals(o)) return false;
        SpellCard spellCard = (SpellCard) o;
        return Objects.equals(spellType, spellCard.spellType) && Objects.equals(description, spellCard.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), spellType, description);
    }
}
