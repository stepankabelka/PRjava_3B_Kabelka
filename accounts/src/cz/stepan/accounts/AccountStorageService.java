package cz.stepan.accounts;

import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
@Singleton
public class AccountStorageService {
    static List<BaseBankAccount> allBankAccounts = new ArrayList<BaseBankAccount>();

    public List<BaseBankAccount> getAllBankAccounts() {
        return allBankAccounts;
    }

    public BaseBankAccount getAccountByAccountNumber(String bankAccountNumber) {
        for (BaseBankAccount bankAccount : allBankAccounts) {
            if (bankAccount.getBankAccountNumber().equals(bankAccountNumber)) {
                return bankAccount;
            }
        }
        throw new IllegalArgumentException();
    }

    List<SaveAccount> allSaveAccounts = new ArrayList<SaveAccount>();


    public List<SaveAccount> getSaveAccounts() {
        return allSaveAccounts;
    }

}
