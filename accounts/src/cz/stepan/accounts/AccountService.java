package cz.stepan.accounts;

import com.google.inject.Inject;
import cz.stepan.card.PaymentCardLogger;
import cz.stepan.customers.Customer;

import java.util.List;

public class AccountService {

    @Inject
    public Warningcheck warningcheck;
    @Inject
    public PaymentCardLogger paymentCardLogger;
    @Inject
    public AccountFactory accountFactory;
    @Inject
    public AccountStorageService accountStorageService;

    public void addBalance(double amount, BaseBankAccount account){
        warningcheck.Check(amount);
        account.balance += amount;
        paymentCardLogger.logBalance(true,account.getBankAccountNumber(), amount);

    }
    public void subBalance(double amount, BaseBankAccount account) {
        if(account.balance - amount < 0){
            System.out.println("not enough money for transaction");
        }else {
            account.balance -= amount;
        }
        paymentCardLogger.logBalance(false,account.getBankAccountNumber(), amount);
    }

    public void addSaveBankAccount(String uuid, Customer customer, float interestRate) {
        List<SaveAccount> sAccounts = accountStorageService.getSaveAccounts();
        SaveAccount account = accountFactory.createSaveAccount(uuid, customer, interestRate);
        sAccounts.add(account);
    }
}
