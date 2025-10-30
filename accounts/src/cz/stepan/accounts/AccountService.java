package cz.stepan.accounts;

import com.google.inject.Inject;
import cz.stepan.card.PaymentCardLogger;




public class AccountService {

    @Inject
    public Warningcheck warningcheck;
    @Inject
    public PaymentCardLogger paymentCardLogger;

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
}
