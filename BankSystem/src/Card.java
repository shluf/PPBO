public class Card {
    public enum Type {
        DEBIT,
        CREDIT
    }
    private int CardNumber;
    private Type type;
    private int saldo;
    private boolean isActive;
    private Owner owner;
    private int pin;

    public int getCardNumber() {
        return CardNumber;
    }

    public Type getType() {
        return type;
    }

    public int getSaldo() {
        return saldo;
    }

    public boolean isActive() {
        return isActive;
    }

    public Owner getOwner() {
        return owner;
    }

    public int getPin() {
        return pin;
    }


    public void setActive(boolean active) {
        isActive = active;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public Card(int CardNumber, int saldo, Owner owner, int pin, Type type) {
        this.CardNumber=CardNumber;
        this.type=type;
        this.saldo=saldo;
        this.owner=owner;
        this.pin=pin;
    }
}
