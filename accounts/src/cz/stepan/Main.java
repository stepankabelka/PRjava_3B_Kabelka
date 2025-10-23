package cz.stepan;

import cz.stepan.accounts.*;
import cz.stepan.card.PaymentCardLogger;
import cz.stepan.card.PaymentCardService;
import cz.stepan.customers.Customer;

public class Main {
    Warningcheck warningcheck = new Warningcheck();
    AccountService accountService = new AccountService();
    PaymentCardService paymentCardService = new PaymentCardService();
    AccountFactory accountFactory = new AccountFactory();
    public static PaymentCardLogger paymentCardLogger = new PaymentCardLogger();
    public void main(String[] args) {



        Customer customer = new Customer("c-1230", "Tomas", "Pesek");
        BankAccount account = accountFactory.createBankAccount("c-1231", customer);


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
