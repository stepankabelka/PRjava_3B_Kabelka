package accounts;

import persons.customers.Customer;

public class BaseBankAccount {
    private String uuid;

    private String bankAccountNumber;

    private Customer customer;

    public double balance;

    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
    }





    public String getUuid() {
        return uuid;
    }
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }
    public Customer getCustomer() {
        return customer;
    }
    public double getBalance() {
        return balance;
    }


}
//test
