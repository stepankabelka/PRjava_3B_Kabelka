package cz.stepan.Interest;

import cz.stepan.accounts.SaveAccount;

public class InterestCalculator {
    public double calculate(SaveAccount saveAccount) {
        return saveAccount.balance + saveAccount.balance / 100 * saveAccount.getInterestRate();
    }
}
