package cz.stepan.accounts;

import cz.stepan.card.PaymentCard;
import cz.stepan.customers.Customer;

import java.util.ArrayList;
import java.util.List;

public class BankAccount extends BaseBankAccount {

    public List<PaymentCard> cards;



        public BankAccount(String uuid, String bankAccountNumber, Customer customer) {
            super(uuid, bankAccountNumber, customer, 0);
            this.cards = new ArrayList<PaymentCard>();
        }

    public List<PaymentCard> getCards() {
        return cards;
    }
}

