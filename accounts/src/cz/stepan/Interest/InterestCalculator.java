package cz.stepan.Interest;

import cz.stepan.accounts.SaveAccount;

public class InterestCalculator {
    public double calculate(SaveAccount saveAccount) {
        return saveAccount.getBalance() / 100 * saveAccount.getInterestRate();
    }
}
