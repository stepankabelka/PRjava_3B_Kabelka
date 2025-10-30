package cz.stepan.card;

import com.google.inject.Inject;
import cz.stepan.accounts.BankAccount;



public class PaymentCardFactory {
    @Inject
    public PaymentCardCvvGenerator paymentCardCvvGenerator;

    @Inject
    public PaymentCardExpireCalculator paymentCardExpireCalculator;

    @Inject
    public PaymentCardNumberGenerator paymentCardNumberGenerator;

    public PaymentCard createCard(String owner, BankAccount bankAccount) {
        String cardNumber = paymentCardNumberGenerator.generateCardNumber(16);
        String cvv = paymentCardCvvGenerator.generateCvv();
        String expireMonth = paymentCardExpireCalculator.calculateMonthExpire();
        String expireYear = paymentCardExpireCalculator.calculateYearExpire();

        return new PaymentCard(owner,expireYear,expireMonth,cvv,cardNumber,bankAccount);
    }


}
