package accounts;

import card.PaymentCard;
import card.PaymentCardFactory;
import persons.customers.Customer;

import java.util.List;

public class BankAccountWithPaymentCards extends BaseBankAccount  {

    public String owner;

    public BankAccountWithPaymentCards(String uuid, String bankAccountNumber, Customer customer, double balance) {
        super(uuid, bankAccountNumber, customer, balance);
    }

}
