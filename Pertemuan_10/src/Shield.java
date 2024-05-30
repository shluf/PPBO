public class Shield extends Item {
    private final int damageBlock;

    public Shield(String name, char rank, int price, int damageBlock) {
        super(name, rank, price);
        this.damageBlock = damageBlock;
    }

    public String defense() {
        return "Damage Mitigated by " + this.damageBlock;
    }
}

