package accounts;

import persons.customers.Customer;

public class BankAccount extends BaseBankAccount {
        public BankAccount(String uuid, String bankAccountNumber, Customer customer) {
            super(uuid, bankAccountNumber, customer, 0);
        }
    }

