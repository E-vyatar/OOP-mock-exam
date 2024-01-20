import java.util.Objects;
import java.util.Scanner;

public class WeaponCard extends Card{

    private int durability;

    public void setDurability(int durability) {
        this.durability = durability;
    }

    public static WeaponCard read(String input) {
        Scanner scanner = new Scanner(input);
        WeaponCard weaponCard = new WeaponCard();
        scanner.nextLine();
        weaponCard.setRarity(scanner.nextLine());
        scanner.useDelimiter(" - ");
        weaponCard.setName(scanner.next());
        weaponCard.setEnergyCost(Integer.parseInt(scanner.nextLine().substring(3,4)));

        weaponCard.setDurability(Integer.parseInt(scanner.nextLine().substring(0,1)));

        return weaponCard;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeaponCard)) return false;
        if (!super.equals(o)) return false;
        WeaponCard that = (WeaponCard) o;
        return durability == that.durability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), durability);
    }
}
