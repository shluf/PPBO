public class Main {
    public static void main(String[] args) {
        Potion potionAttack = new Potion("Fire Potion", 'C', 5000, 3, 10, Type.ATTACK);
        Potion potionHeal = new Potion("Healing Potion", 'B', 20000, 5, 20, Type.HEAL);

        Sword sword = new Sword("Excalibur", 'S', 35000, 75);
        Shield shield = new Shield("Aegis", 'S', 30000, 50);

        System.out.println(potionAttack.use());
        System.out.println(potionHeal.use());
        System.out.println(sword.attack());
        System.out.println(shield.defense());
    }
}

