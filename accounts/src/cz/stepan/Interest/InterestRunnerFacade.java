package cz.stepan.Interest;

import com.google.inject.Inject;
import cz.stepan.accounts.AccountStorageService;
import cz.stepan.accounts.SaveAccount;
import cz.stepan.card.PaymentCardLogger;
import cz.stepan.card.PaymentCardStorageService;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public class InterestRunnerFacade {

    @Inject
    public AccountStorageService accountStorageService;
    @Inject
    public InterestCalculator interestCalculator;
    @Inject
    public PaymentCardLogger paymentCardLogger;
    @Inject
    public void processAllInterests() {
    accountStorageService.getSaveAccounts().forEach(account -> {
        if((account.getNextInterestDate().isBefore(LocalDateTime.now()))){
            account.balance += interestCalculator.calculate(account);
            account.nextInterestDate = account.getNextInterestDate().plusSeconds(5);
            System.out.println(account.getBalance());
        }

    });
    }
}

