package cz.stepan.accounts;

import cz.stepan.card.PaymentCard;
import jakarta.inject.Singleton;

import java.util.ArrayList;
import java.util.List;
@Singleton
public class AccountStorageService {
    List<SaveAccount> allSaveAccounts = new ArrayList<SaveAccount>();


    public List<SaveAccount> getSaveAccounts() {
        return allSaveAccounts;
    }

}
