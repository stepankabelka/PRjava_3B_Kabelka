package card;

import java.util.ArrayList;
import java.util.List;

public class PaymentCardStorageService {

    static List<PaymentCard>  allCards = new ArrayList<PaymentCard>();

    public static List<PaymentCard> getCards() {
        return allCards;
    }

    public PaymentCard returnCardByCardNumber(String cardNumber) {
        for (PaymentCard card : allCards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        throw new IllegalArgumentException();
    }
}
