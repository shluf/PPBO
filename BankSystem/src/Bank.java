import java.util.ArrayList;
import java.util.List;
public class Bank {
    private String name;
    private List<Card> cards = new ArrayList<>();

    public void addCard(Card card) {
            cards.add(card);
    }

    public Boolean isCardNumberValid(int newNumber) {
        for (Card card : cards) {
            if (newNumber == card.getCardNumber()) {
                return false;
            }
        }
        return true;
    }
}
