package cz.stepan;

import com.google.inject.Inject;
import cz.stepan.Interest.Cron;
import cz.stepan.accounts.*;
import cz.stepan.accounts.transferEntries.AccTransferEntryCronService;
import cz.stepan.card.PaymentCardLogger;
import cz.stepan.card.PaymentCardService;
import cz.stepan.customers.Customer;

public class App {
    @Inject
    public AccountFactory accountFactory;

    @Inject
    public PaymentCardService paymentCardService;

    @Inject
    public AccountService accountService;

    @Inject
    public PaymentCardLogger paymentCardLogger;

    @Inject
    public AccountStorageService accountStorageService;

    @Inject
    public Cron cron;
    @Inject
    public AccTransferEntryCronService accTransferEntryCronService;

    public void run(){


        Customer customer = new Customer("c-1230", "Tomas", "Pesek");
        BankAccount account = accountFactory.createBankAccount("c-1231", customer);
        accountService.addSaveBankAccount("c-1234",customer,3.5f);
        accountService.addSaveBankAccount("c-1254",customer,4f);

        accountService.addBalance(1500, accountStorageService.getSaveAccounts().get(0));
        accountService.addBalance(2423, accountStorageService.getSaveAccounts().get(1));
        accountService.addBalance(500,account);
        accountService.subBalance(200,account);
        System.out.println(account.getBalance());

        paymentCardService.addPaymentCard(account);
        paymentCardService.addPaymentCard(account);
        paymentCardService.addPaymentCard(account);
        paymentCardService.addPaymentCard(account);

        paymentCardService.removePaymentCard(account,(account.getCards().getFirst().getCardNumber()));
        System.out.println("\nCards: ");
        account.getCards().forEach(card -> System.out.println(card.getCardNumber() + " " + card.getBankAccount().getBankAccountNumber()));
        paymentCardLogger.showLog();
        cron.start();
        accTransferEntryCronService.start();

    }
}
