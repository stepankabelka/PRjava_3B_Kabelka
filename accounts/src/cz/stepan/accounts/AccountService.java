package cz.stepan.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import cz.stepan.Interest.InterestCalculator;
import cz.stepan.accounts.transferEntries.AccTransferEntryFactory;
import cz.stepan.accounts.transferEntries.Actions;
import cz.stepan.card.PaymentCardLogger;
import cz.stepan.customers.Customer;

import java.util.List;

@Singleton
public class AccountService {

    @Inject
    public Warningcheck warningcheck;
    @Inject
    public PaymentCardLogger paymentCardLogger;
    @Inject
    public AccountFactory accountFactory;
    @Inject
    public AccountStorageService accountStorageService;
    @Inject
    public InterestCalculator interestCalculator;
    @Inject
    public AccTransferEntryFactory accTransferEntryFactory;

    public void addBalance(double amount, BaseBankAccount account){
        warningcheck.Check(amount);
        account.balance += amount;
        paymentCardLogger.logBalance("add",account.getBankAccountNumber(), amount);
        account.getAccTransferEntries().add(accTransferEntryFactory.createAccTransferEntry(Actions.ADD, amount));

    }
    public void subBalance(double amount, BaseBankAccount account) {
        if(account.balance - amount < 0){
            System.out.println("not enough money for transaction");
        }else {
            account.balance -= amount;
        }
        paymentCardLogger.logBalance("sub",account.getBankAccountNumber(), amount);
        account.getAccTransferEntries().add(accTransferEntryFactory.createAccTransferEntry(Actions.SUB, amount));

    }

    public void addSaveBankAccount(String uuid, Customer customer, float interestRate) {
        SaveAccount account = accountFactory.createSaveAccount(uuid, customer, interestRate);
        accountStorageService.getSaveAccounts().add(account);

    }
    public void interest(SaveAccount saveAccount) {
        double interest = interestCalculator.calculate(saveAccount);
        saveAccount.setBalance(saveAccount.getBalance() + interest);
        paymentCardLogger.logBalance("interest",saveAccount.getBankAccountNumber(), interest);
        saveAccount.getAccTransferEntries().add(accTransferEntryFactory.createAccTransferEntry(Actions.INTEREST, interest));
    }
}
