package accounts;

import persons.customers.Customer;

public class BaseBankAccount {
    private String uuid;

    private String bankAccountNumber;

    private Customer customer;

    private double balance;

    public BaseBankAccount(String uuid, String bankAccountNumber, Customer customer, double balance) {
        this.uuid = uuid;
        this.bankAccountNumber = bankAccountNumber;
        this.customer = customer;
        this.balance = balance;
    }

    public void  addBalance(double amount){
        this.balance += amount;
    }
    public void subBalance(double amount) {
        if(this.balance - amount < 0){
            System.out.println("not enough money for transaction");
        }else {
            this.balance -= amount;
        }
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
