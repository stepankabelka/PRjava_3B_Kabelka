package cz.stepan.Interest;

import com.google.inject.Inject;
import cz.stepan.card.PaymentCardLogger;

import java.time.LocalDateTime;


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
            account.balance = interestCalculator.calculate(account);
            account.nextInterestDate = account.getNextInterestDate().plusSeconds(5);
            System.out.println(account.getBalance());
        }

    });
    }
}

