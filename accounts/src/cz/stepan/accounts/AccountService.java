package cz.stepan.accounts;

import cz.stepan.card.PaymentCardService;
import com.sun.tools.javac.Main;

import static cz.stepan.Main.paymentCardLogger;

public class AccountService {
    PaymentCardService paymentCardService =  new PaymentCardService();
    Warningcheck warningcheck = new Warningcheck();

    public void Check(double amount)
    {
        warningcheck.Check(amount);
    }
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
