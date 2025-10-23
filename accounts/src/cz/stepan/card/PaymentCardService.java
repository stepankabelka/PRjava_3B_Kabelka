package cz.stepan.card;

import cz.stepan.Main;
import cz.stepan.accounts.BankAccount;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class PaymentCardService {
    PaymentCardStorageService paymentCardStorageService = new PaymentCardStorageService();
    PaymentCardFactory pcf = new PaymentCardFactory();


    public void addPaymentCard(BankAccount bankAccount) {
        List<PaymentCard> cards = bankAccount.getCards();
        PaymentCard card = pcf.createCard(bankAccount.getCustomer().getFullName(), bankAccount);
        paymentCardStorageService.getCards().add(card);
        cards.add(card);
        Main.paymentCardLogger.logCard(true, card.getCardNumber(),bankAccount.getBankAccountNumber());
    }

    public  void removePaymentCard(BankAccount bankAccount, String cardNumber) {
        AtomicReference<PaymentCard> toRemove = new AtomicReference<>();
        List<PaymentCard> cards = bankAccount.getCards();
        cards.forEach((card) -> {
            if (card.getCardNumber().equals(cardNumber)) {
                toRemove.set(card);
            }
        });
        cards.remove(toRemove.get());
        Main.paymentCardLogger.logCard(false, cardNumber,bankAccount.getBankAccountNumber());

    }


}
