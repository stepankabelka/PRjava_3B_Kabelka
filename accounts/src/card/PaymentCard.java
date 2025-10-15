package card;

import accounts.BankAccount;

public class PaymentCard {

    private String cardNumber;

    private String cvv;

    private   String expireMont;

    private   String expireYear;

    private   String owner;

    private BankAccount bankAccount;

    public PaymentCard(String owner, String expireYear, String expireMont, String cvv, String cardNumber, BankAccount bankAccount) {
        this.owner = owner;
        this.expireYear = expireYear;
        this.expireMont = expireMont;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.bankAccount = bankAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
