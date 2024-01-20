import java.util.Objects;
import java.util.Scanner;

public class UnitCard extends Card{

    private int attack;

    private int defence;

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public UnitCard() {

    }

    public static UnitCard read(String input) {
        Scanner scanner = new Scanner(input);
        UnitCard unitCard = new UnitCard();
        scanner.nextLine();
        unitCard.setRarity(scanner.nextLine());
        scanner.useDelimiter(" - ");
        unitCard.setName(scanner.next());
        unitCard.setEnergyCost(Integer.parseInt(scanner.nextLine().substring(3,4)));

        scanner.useDelimiter(" ");

        unitCard.setAttack(Integer.parseInt(scanner.next()));
        scanner.useDelimiter(" Attack - ");
        unitCard.setDefence(Integer.parseInt(scanner.next().substring(0,1)));

        return unitCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UnitCard)) return false;
        if (!super.equals(o)) return false;
        UnitCard unitCard = (UnitCard) o;
        return attack == unitCard.attack && defence == unitCard.defence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), attack, defence);
    }
}
