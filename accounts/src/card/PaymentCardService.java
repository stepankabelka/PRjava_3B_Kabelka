package card;

import accounts.BankAccount;
import persons.customers.Customer;

import java.util.List;

public class PaymentCardService {

    PaymentCardFactory pcf = new PaymentCardFactory();

    public void addPaymentCard(BankAccount bankAccount) {
        List<PaymentCard> cards = bankAccount.getCards();
        PaymentCard card = pcf.createCard(bankAccount.owner, bankAccount);
        PaymentCardStorageService.getCards().add(card);
        cards.add(card);
    }

    public  void removePaymentCard(BankAccount bankAccount, String cardNumber) {
        List<PaymentCard> cards = bankAccount.getCards();
        cards.forEach((card) -> {
            if (card.getCardNumber().equals(cardNumber)) {
                bankAccount.cards.remove(card);
            }
        });
    }


}
