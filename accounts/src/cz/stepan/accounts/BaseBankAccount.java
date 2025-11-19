package cz.stepan.accounts;

import cz.stepan.accounts.transferEntries.AccTransferEntry;
import cz.stepan.customers.Customer;

import java.util.ArrayList;
import java.util.List;

public class BaseBankAccount {
    private String uuid;

    private String bankAccountNumber;

    private Customer customer;

    public double balance;

    private List<AccTransferEntry> accountTransferEntries;


    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
        this.accountTransferEntries = new ArrayList<AccTransferEntry>();
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
    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<AccTransferEntry> getAccTransferEntries() {
        return accountTransferEntries;
    }


}
//test
