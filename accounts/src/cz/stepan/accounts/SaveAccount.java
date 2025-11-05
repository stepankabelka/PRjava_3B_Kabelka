package cz.stepan.accounts;

import cz.stepan.customers.Customer;

import com.google.inject.Inject;
import java.time.LocalDateTime;


public class SaveAccount extends BaseBankAccount {
    private final float interestRate;
    private LocalDateTime nextInterestDate;

    public SaveAccount(String uuid, String bankAccountNumber, Customer customer, float interestRate, LocalDateTime nextInterestDate) {
        super(uuid, bankAccountNumber, customer, 0);
        this.interestRate = interestRate;
        this.nextInterestDate = nextInterestDate;
    }

    public float getInterestRate() {
        return interestRate;
    }

    @Override
    public double getBalance() {
        return super.getBalance();
    }


    public LocalDateTime getNextInterestDate() {
        return nextInterestDate;
    }
}
