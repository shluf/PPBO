public class Sword extends Item {
    private final int damage;

    public Sword(String name, char rank, int price, int damage) {
        super(name, rank, price);
        this.damage = damage;
    }

    public String attack() {
        return "Damage dealt by " + this.damage;
    }
}

