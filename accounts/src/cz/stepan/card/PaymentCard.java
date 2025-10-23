package cz.stepan.card;

import cz.stepan.accounts.BankAccount;

public class PaymentCard {

    private String cardNumber;

    private String cvv;

    private   String expireMonth;

    private   String expireYear;

    private   String owner;

    private BankAccount bankAccount;

    public PaymentCard(String owner, String expireYear, String expireMonth, String cvv, String cardNumber, BankAccount bankAccount) {
        this.owner = owner;
        this.expireYear = expireYear;
        this.expireMonth = expireMonth;
        this.cvv = cvv;
        this.cardNumber = cardNumber;
        this.bankAccount = bankAccount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public String getExpireMonth() {
        return expireMonth;
    }

    public String getExpireYear() {
        return expireYear;
    }

    public String getOwner() {
        return owner;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
