package card;

import accounts.BankAccount;

public class PaymentCardFactory {

    PaymentCardNumberGenerator paymentCardNumberGenerator = new PaymentCardNumberGenerator();
    PaymentCardExpireCalculator paymentCardExpireCalculator = new PaymentCardExpireCalculator();
    PaymentCardCvvGenerator paymentCardCvvGenerator = new PaymentCardCvvGenerator();

    public PaymentCard createCard(String owner, BankAccount bankAccount) {
        String cardNumber = paymentCardNumberGenerator.generateCardNumber();
        String cvv = paymentCardCvvGenerator.generateCvv();
        String expireMonth = paymentCardExpireCalculator.calculateMonthExpire();
        String expireYear = paymentCardExpireCalculator.calculateYearExpire();

        return new PaymentCard(owner,expireYear,expireMonth,cvv,cardNumber,bankAccount);
    }


}
