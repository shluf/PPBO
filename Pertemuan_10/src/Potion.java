public class Potion extends Item {
    private int duration;
    private final int effectPoint;
    private final Type type;

    public Potion(String name,
                  char rank,
                  int price,
                  int duration,
                  int effectPoint,
                  Type type) {
        super(name, rank, price);
        this.duration = duration;
        this.effectPoint = effectPoint;
        this.type = type;
    }
    public String use() {
        switch (type) {
            case ATTACK -> {
                return "Damage dealt by " + this.effectPoint;
            }
            case HEAL -> {
                return "Healed by " + this.effectPoint;
            }
            default -> {
                return "Unknown potion type";
            }
        }
    }
}

