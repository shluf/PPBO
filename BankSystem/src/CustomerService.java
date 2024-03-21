import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

public class CustomerService {
    private static Bank bank = new Bank();
    public static void createCard(
            int nik,
            String name,
            String dateOfBirthInString,
            Card.Type type,
            int saldo,
            int pin
    ) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH);
        Date date;
        try {
            date = dateFormat.parse(dateOfBirthInString);
        } catch (Exception e) {
            date = new Date();
        }
    }
//    Owner owner = new Owner(nik, name, date);

    Random rand = new Random();

    int newCardNumber = rand.nextInt(999999);

    while (bank.isCardNumberValid(newCardNumber)) {
        int newCardNumber = rand.nextInt(999999);
    }

}
