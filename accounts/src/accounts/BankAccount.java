package accounts;

import card.PaymentCard;
import persons.customers.Customer;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.List;

public class BankAccount extends BankAccountWithPaymentCards {

    public List<PaymentCard> cards;

        public BankAccount(String uuid, String bankAccountNumber, Customer customer) {
            super(uuid, bankAccountNumber, customer, 0);
            this.cards = new ArrayList<PaymentCard>();
        }

    public List<PaymentCard> getCards() {
        return cards;
    }
}

