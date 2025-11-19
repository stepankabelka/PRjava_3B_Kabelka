package cz.stepan.card;

import cz.stepan.card.creation.PaymentCard;

import java.util.ArrayList;
import java.util.List;

public class PaymentCardStorageService {

    List<PaymentCard>  allCards = new ArrayList<PaymentCard>();

    public List<PaymentCard> getCards() {
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
