package cz.stepan;

import com.google.inject.Inject;
import cz.stepan.accounts.AccountFactory;
import cz.stepan.accounts.AccountService;
import cz.stepan.accounts.BankAccount;
import cz.stepan.accounts.SaveAccount;
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


    public void run(){


        Customer customer = new Customer("c-1230", "Tomas", "Pesek");
        BankAccount account = accountFactory.createBankAccount("c-1231", customer);
        SaveAccount aAccount = accountFactory.createSaveAccount("c-1234",customer,3.5f);

        accountService.addBalance(1000,aAccount);
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
    }
}
